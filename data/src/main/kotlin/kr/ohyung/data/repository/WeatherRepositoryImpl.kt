/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.data.repository

import io.reactivex.Single
import kr.ohyung.data.network.api.WeatherApi
import kr.ohyung.data.network.response.toEntity
import kr.ohyung.domain.entity.Forecast
import kr.ohyung.domain.repository.WeatherRepository

class WeatherRepositoryImpl(private val weatherApi: WeatherApi) : WeatherRepository {

    override fun getWeatherByLatLon(lat: Double, lon: Double): Single<Forecast> =
        weatherApi.getWeatherForecastByLatLon(lat, lon)
            .map { it.toEntity() }
}
