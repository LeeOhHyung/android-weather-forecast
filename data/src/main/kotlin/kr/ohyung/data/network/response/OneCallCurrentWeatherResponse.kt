/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.data.network.response

import com.google.gson.annotations.SerializedName
import kr.ohyung.domain.entity.Weather

data class OneCallCurrentWeatherResponse(

    @SerializedName("dt")
    val currentTimeInMillis: Long,

    @SerializedName("sunrise")
    val sunrise: Long?,

    @SerializedName("sunset")
    val sunset: Long?,

    @SerializedName("temp")
    val temp: Double,

    @SerializedName("feel_like")
    val feelsLike: Double?,

    @SerializedName("rain")
    val rain: OneCallRainResponse?,

    @SerializedName("snow")
    val snow: OneCallSnowResponse?,

    @SerializedName("weather")
    val weather: List<WeatherIconResponse>

): OneCallWeatherEssentialFieldsResponse()

fun OneCallCurrentWeatherResponse.toEntity(
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
        currentTimeInMillis = currentTimeInMillis,
        sunriseTimeInMillis = sunrise,
        sunsetTimeInMillis = sunset,
        temp = temp,
        feelsLike = feelsLike,
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
