package kr.ohyung.weather.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver
import kr.ohyung.domain.exception.InvalidLatLonException
import kr.ohyung.domain.usecase.GetCurrentLocationForecastUseCase
import kr.ohyung.weather.base.BaseViewModel

/**
 * Created by Lee Oh Hyoung on 2020/07/08.
 */
class MainViewModel(
    private val getCurrentLocationForecastUseCase: GetCurrentLocationForecastUseCase
) : BaseViewModel() {

    private val _uiState = MutableLiveData<MainUiState>()
    val uiState: LiveData<MainUiState>
        get() = _uiState

    init {
        _uiState.value = MainUiState.Loading
    }

    fun getForecast(latitude: Double, longitude: Double) =
        getCurrentLocationForecastUseCase
            .execute(Pair(latitude, longitude))
            .flatMap { forecast -> Single.just(forecast.asState()) }
            .subscribe({ content ->
                _uiState.value = content
            }, { exception ->
                when(exception) {
                    is InvalidLatLonException -> {
                        _uiState.value = exception.asErrorState()
                    }
                }
            })
            .addDisposable()

    fun getForecastBySingleObserver() =
        getCurrentLocationForecastUseCase
            .execute(Pair(37.527393, 126.887577)) // latitude, longitude
            .flatMap { forecast -> Single.just(forecast.asState()) }
            .subscribe(object: DisposableSingleObserver<MainUiState.Content>() {
                override fun onSuccess(state: MainUiState.Content) {
                    _uiState.value = state
                }

                override fun onError(e: Throwable) {
                    when(e) {
                        is InvalidLatLonException -> {
                            _uiState.value = e.asErrorState()
                        }
                    }
                }
            })
}
