package kr.ohyung.data.network

import kr.ohyung.data.BuildConfig
import com.orhanobut.logger.Logger
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Lee Oh Hyoung on 2020/07/09.
 */
object RetrofitManager {

    private const val TAG: String = "RetrofitManager"

    private const val CONNECT_TIMEOUT: Long = 30L
    private const val WRITE_TIMEOUT: Long = 30L
    private const val READ_TIMEOUT: Long = 30L

    private const val HEADER_NAVER_MAP_CLIENT_ID: String = "X-NCP-APIGW-API-KEY-ID"
    private const val HEADER_NAVER_MAP_CLIENT_SECRET: String = "X-NCP-APIGW-API-KEY"

    fun getWeatherRetrofit(): Retrofit =
        getRetrofit(BuildConfig.WEATHER_BASE_URL)

    fun getNaverMapRetrofit(): Retrofit =
        getRetrofit(BuildConfig.NAVER_MAP_BASE_URL)

    private fun getRetrofit(baseUrl: String) : Retrofit =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(getOkHttpClient())
            .build()


    private fun getOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .retryOnConnectionFailure(true)
            .connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(WRITE_TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(READ_TIMEOUT, TimeUnit.SECONDS)
            .addInterceptor(getHttpLoggerInterceptor())
            .addInterceptor(createNaverMapHeaderInterceptor())
            .build()

    private fun getHttpLoggerInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor(createLogger())
            .apply {
                level =
                    if(BuildConfig.DEBUG)
                        HttpLoggingInterceptor.Level.BODY
                    else
                        HttpLoggingInterceptor.Level.NONE
            }

    private fun createLogger(): HttpLoggingInterceptor.Logger =
        object: HttpLoggingInterceptor.Logger {
            override fun log(message: String) {
                try {
                    JSONObject(message)
                    Logger.t(TAG).json(message)
                } catch (e: JSONException) {
                    Logger.t(TAG).d(message)
                }
        }
    }

    private fun createNaverMapHeaderInterceptor(): Interceptor =
        object: Interceptor {
            override fun intercept(chain: Interceptor.Chain): Response =
                chain.proceed(
                    chain.request().newBuilder()
                        .addHeader(HEADER_NAVER_MAP_CLIENT_ID, BuildConfig.NAVER_MAP_CLIENT_ID)
                        .addHeader(HEADER_NAVER_MAP_CLIENT_SECRET, BuildConfig.NAVER_MAP_CLIENT_SECRET)
                        .build()
                )

    }
}
