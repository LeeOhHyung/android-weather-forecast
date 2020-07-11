/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.domain.entity

import kr.ohyung.domain.Entity

data class Weather(
    val latitude: Double,
    val longitude: Double,
    val timezone: String,
    val timezoneOffset: Int,
    val currentTimeInMillis: Long,
    val sunriseTimeInMillis: Long?,
    val sunsetTimeInMillis: Long?,
    val temp: Double,
    val feelsLike: Double?,
    val pressure: Int,
    val humidity: Int,
    val uvi: Double,
    val clouds: Int,
    val visibility: Int,
    val windSpeed: Double, // meter per sec,
    val rain: Double?,
    val snow: Double?,
    val weatherName: String,
    val weatherDescription: String,
    val weatherIcon: String
): Entity
