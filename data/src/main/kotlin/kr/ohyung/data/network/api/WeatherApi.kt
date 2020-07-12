/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.data.network.api

import io.reactivex.Single
import kr.ohyung.data.Api
import kr.ohyung.data.BuildConfig
import kr.ohyung.data.network.response.OneCallWeatherByLatLonResponse
import kr.ohyung.domain.entity.TempUnits
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi : Api {

    @GET("onecall")
    fun getWeatherForecastByLatLon(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("units") units: String = TempUnits.METRIC.value,
        @Query("appid") appid: String = BuildConfig.WEATHER_API_KEY
    ): Single<OneCallWeatherByLatLonResponse>
}
