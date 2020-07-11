/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.data.network.response

import com.google.gson.annotations.SerializedName
import kr.ohyung.data.Response

data class OneCallHourlyWeatherResponse(

    @SerializedName("dt")
    val timeInMillis: Long,

    @SerializedName("temp")
    val temp: Double,

    @SerializedName("feel_like")
    val feelsLike: Double?,

    @SerializedName("pressure")
    val pressure: Int,

    @SerializedName("humidity")
    val humidity: Int,

    @SerializedName("dew_point")
    val dewPoint: Double,

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
