/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.data.network.response.daily

import com.google.gson.annotations.SerializedName
import kr.ohyung.data.Response
import kr.ohyung.data.network.response.OneCallRainResponse
import kr.ohyung.data.network.response.OneCallSnowResponse
import kr.ohyung.data.network.response.WeatherIconResponse

data class OneCallDailyWeatherResponse(

    @SerializedName("dt")
    val timeInMillis: Long,

    @SerializedName("sunrise")
    val sunrise: Long,

    @SerializedName("sunset")
    val sunset: Long,

    @SerializedName("temp")
    val temp: OneCallDailyTempResponse,

    @SerializedName("feels_like")
    val feelsLike: OneCallDailyFeelsLikeResponse,

    @SerializedName("pressure")
    val pressure: Int,

    @SerializedName("humidity")
    val humidity: Int,

    @SerializedName("dew_point")
    val dewPoint: Double,

    @SerializedName("uvi")
    val uvi: Double,

    @SerializedName("clouds")
    val clouds: Int,

    @SerializedName("visibility") // 가시거리
    val visibility: Int?,

    @SerializedName("wind_speed")
    val windSpeed: Double,

    @SerializedName("wind_deg")
    val windDeg: Int,

    @SerializedName("rain")
    val rain: OneCallRainResponse?,

    @SerializedName("snow")
    val snow: OneCallSnowResponse?,

    @SerializedName("weather")
    val weather: List<WeatherIconResponse>
): Response
