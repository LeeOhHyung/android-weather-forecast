/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.data.network.response.daily

import com.google.gson.annotations.SerializedName
import kr.ohyung.data.Response
import kr.ohyung.data.network.response.OneCallHourlyWeatherResponse
import kr.ohyung.data.network.response.OneCallRainResponse
import kr.ohyung.data.network.response.OneCallSnowResponse
import kr.ohyung.data.network.response.WeatherIconResponse
import kr.ohyung.domain.entity.Weather

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

fun OneCallDailyWeatherResponse.toEntity(
    latitude: Double,
    longitude: Double,
    timezone: String,
    timezoneOffset: Int
): Weather =
    Weather(
        latitude = latitude,
        longitude = longitude,
        timezone = timezone,
        timezoneOffset = timezoneOffset,
        currentTimeInMillis = timeInMillis,
        sunriseTimeInMillis = sunrise,
        sunsetTimeInMillis = sunset,
        temp = temp.day,
        feelsLike = feelsLike.day,
        pressure = pressure,
        humidity = humidity,
        uvi = uvi,
        clouds = clouds,
        visibility = visibility,
        windSpeed = windSpeed,
        rain = rain?.hourPer1,
        snow = snow?.hourPer1,
        weatherName = weather.first().main,
        weatherDescription = weather.first().description,
        weatherIcon = weather.first().icon
    )
