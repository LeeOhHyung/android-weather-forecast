/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.domain.repository

import io.reactivex.Single
import kr.ohyung.domain.Repository
import kr.ohyung.domain.entity.Forecast
import kr.ohyung.domain.entity.Weather

interface WeatherRepository : Repository {

    fun getWeatherByLatLon(lat: Double, lon: Double): Single<Forecast>
}
