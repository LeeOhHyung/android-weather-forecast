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
class RetrofitManager {

    companion object {
        private const val TAG: String = "RetrofitManager"

        private const val CONNECT_TIMEOUT: Long = 30L
        private const val WRITE_TIMEOUT: Long = 30L
        private const val READ_TIMEOUT: Long = 30L
    }

    fun <T> create(service: Class<T>): T =
        getRetrofit().create(service)

    private fun getRetrofit() : Retrofit =
        Retrofit.Builder()
            .baseUrl(BuildConfig.WEATHER_BASE_URL)
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

    private fun createLogger(): HttpLoggingInterceptor.Logger = object: HttpLoggingInterceptor.Logger {

        override fun log(message: String) {
            try {
                JSONObject(message)
                Logger.t(TAG).json(message)
            } catch (e: JSONException) {
                Logger.t(TAG).d(message)
            }
        }
    }
}
