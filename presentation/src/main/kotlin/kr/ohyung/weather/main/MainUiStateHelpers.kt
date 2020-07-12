/*
 * Created by Lee Oh Hyoung on 2020/07/12 .. 
 */
package kr.ohyung.weather.main

import kr.ohyung.domain.entity.Forecast

fun Forecast.asState(): MainUiState.Content =
    MainUiState.Content(
        country = countryCode,
        city = city,
        latitude = current.latitude.toString(),
        longitude = current.longitude.toString(),
        currentDate = current.currentTimeInMillis.toString(),
        currentTemp = current.temp.toString(),
        pressure = current.pressure.toString(),
        humidity = current.humidity.toString(),
        uvi = current.uvi.toString(),
        clouds = current.clouds.toString(),
        visibility = current.visibility.toString(),
        windKmh = current.windSpeed.toString(),
        rain = current.rain.toString(),
        snow = current.snow.toString(),
        weatherIcon = current.weatherIcon,
        weatherName = current.weatherName
    )

fun Throwable.asErrorState(): MainUiState.Error =
    MainUiState.Error(
        errorCode = "",
        errorMessage = this.message.toString(),
        throwable = this.cause
    )
