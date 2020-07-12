/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.data.network.response

import com.google.gson.annotations.SerializedName
import kr.ohyung.data.Response
import kr.ohyung.data.network.response.daily.OneCallDailyWeatherResponse
import kr.ohyung.data.network.response.daily.toEntity
import kr.ohyung.domain.entity.Forecast

data class OneCallWeatherByLatLonResponse(

    @SerializedName("lat")
    val lat: Double,

    @SerializedName("lon")
    val lon: Double,

    @SerializedName("timezone")
    val timezone: String,

    @SerializedName("timezone_offset")
    val timezoneOffset: Int,

    @SerializedName("current")
    val current: OneCallCurrentWeatherResponse,

    @SerializedName("hourly")
    val hourly: List<OneCallHourlyWeatherResponse>,

    @SerializedName("daily")
    val daily: List<OneCallDailyWeatherResponse>
): Response


fun OneCallWeatherByLatLonResponse.toEntity(): Forecast =
    Forecast(
        countryCode = "",
        city = "",
        current =  current.toEntity(lat, lon, timezone, timezoneOffset),
        hourly = hourly.map { it.toEntity(lat, lon, timezone, timezoneOffset, uvi = current.uvi) },
        daily = daily.map { it.toEntity(lat, lon, timezone, timezoneOffset) }
    )
