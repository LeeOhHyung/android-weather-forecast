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
import kr.ohyung.domain.exception.InvalidLocationException
import kr.ohyung.domain.repository.ReverseGeocodingRepository
import kr.ohyung.domain.repository.WeatherRepository

class GetCurrentLocationForecastUseCase(
    private val lat: Double,
    private val lon: Double,
    private val weatherRepository: WeatherRepository,
    private val reverseGeocodingRepository: ReverseGeocodingRepository,
    executorScheduler: Scheduler = Schedulers.io(),
    postExecutionScheduler: Scheduler = AndroidSchedulers.mainThread()
) : SingleUseCase<Forecast>(executorScheduler, postExecutionScheduler) {

    override fun buildUseCaseSingle(): Single<Forecast> =
        if(checkLocationValidation(lat, lon))
            Single.zip(
                weatherRepository.getWeatherByLatLon(lat, lon),
                reverseGeocodingRepository.getCurrentLegalName(lat, lon),
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
            InvalidLocationException(message = "invalid latitude, longitude")
        )

    private fun checkLocationValidation(
        lat: Double,
        lon: Double
    ): Boolean =
        (lat in 32.0..43.0 && lon in 124.0..132.0)

}