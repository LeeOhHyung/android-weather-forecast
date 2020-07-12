package kr.ohyung.weather

import com.orhanobut.logger.Logger
import io.reactivex.observers.DisposableSingleObserver
import kr.ohyung.domain.entity.Forecast
import kr.ohyung.domain.exception.InvalidLatLonException
import kr.ohyung.domain.usecase.GetCurrentLocationForecastUseCase
import kr.ohyung.weather.base.BaseViewModel

/**
 * Created by Lee Oh Hyoung on 2020/07/08.
 */
class MainViewModel(
    private val getCurrentLocationForecastUseCase: GetCurrentLocationForecastUseCase
) : BaseViewModel() {

    fun getForecast() =
        getCurrentLocationForecastUseCase
            .execute(Pair(37.527393, 126.887577)) // latitude, longitude
            .subscribe({ forecast ->
                // do something
                Logger.d("forecast: $forecast")
            }, { exception ->
                Logger.d("exception: $exception, errorMessage : ${exception.message.toString()}")

                // handle error
                if(exception is InvalidLatLonException) {
                    /* explicitly empty */
                }
            })
            .addDisposable()

    fun getForecastBySingleObserver() = 
        getCurrentLocationForecastUseCase
            .execute(Pair(37.527393, 126.887577)) // latitude, longitude
            .subscribe(object: DisposableSingleObserver<Forecast>() {
                override fun onSuccess(forecast: Forecast) {
                    // do something with forecast
                }

                override fun onError(e: Throwable) {
                    // exception handling
                }
            })
}
