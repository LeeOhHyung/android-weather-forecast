/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.domain.usecase

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.BiFunction
import io.reactivex.schedulers.Schedulers
import kr.ohyung.domain.entity.Forecast
import kr.ohyung.domain.entity.LocationLegalName
import kr.ohyung.domain.exception.InvalidLatLonException
import kr.ohyung.domain.repository.ReverseGeocodingRepository
import kr.ohyung.domain.repository.WeatherRepository
import kr.ohyung.domain.usecase.base.SingleUseCase

class GetCurrentLocationForecastUseCase(
    private val weatherRepository: WeatherRepository,
    private val reverseGeocodingRepository: ReverseGeocodingRepository,
    executorScheduler: Scheduler = Schedulers.io(),
    postExecutionScheduler: Scheduler = AndroidSchedulers.mainThread()
) : SingleUseCase<Forecast>(executorScheduler, postExecutionScheduler) {

    var latitude: Double = Double.MAX_VALUE
    var longitude: Double = Double.MAX_VALUE

    override fun buildUseCaseSingle(): Single<Forecast> =
        if(checkLocationValidation())
            Single.zip(
                weatherRepository.getWeatherByLatLon(latitude, longitude),
                reverseGeocodingRepository.getCurrentLegalName(latitude, longitude),
                BiFunction { emptyCityForecast: Forecast, legalName: LocationLegalName ->
                    Forecast(
                        country = legalName.countryCode,
                        city = legalName.city,
                        current = emptyCityForecast.current,
                        hourly = emptyCityForecast.hourly,
                        daily = emptyCityForecast.daily
                    )
                }
            )
        else Single.error(
            InvalidLatLonException(message = "invalid latitude and longitude")
        )

    private fun checkLocationValidation(): Boolean =
        (latitude in 32.0..43.0 && longitude in 124.0..132.0)

}