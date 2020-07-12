package kr.ohyung.weather

import com.orhanobut.logger.Logger
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
            .execute(Pair(32.4, 127.4)) // latitude, longitude
            .subscribe({ forecast ->
                // do something
                Logger.d("forecast : $forecast")
            }, { exception ->
                Logger.d("error : ${exception.message.toString()}")

                // handle error
                if(exception is InvalidLatLonException) {
                    /* explicitly empty */
                }
            })
            .addDisposable()
}
