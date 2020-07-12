/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.data.network.response.daily

import com.google.gson.annotations.SerializedName
import kr.ohyung.data.network.response.OneCallWeatherEssentialFieldsResponse
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

    @SerializedName("rain")
    val rain: Double?,

    @SerializedName("snow")
    val snow: Double?,

    @SerializedName("weather")
    val weather: List<WeatherIconResponse>

): OneCallWeatherEssentialFieldsResponse()

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
        rain = rain,
        snow = snow,
        weatherName = weather.first().main,
        weatherDescription = weather.first().description,
        weatherIcon = weather.first().icon
    )
