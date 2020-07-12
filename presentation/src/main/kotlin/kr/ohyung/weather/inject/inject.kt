package kr.ohyung.weather.inject

import kr.ohyung.data.network.RetrofitManager
import kr.ohyung.data.network.api.ReverseGeocodingApi
import kr.ohyung.data.network.api.WeatherApi
import kr.ohyung.data.repository.ReverseGeocodingRepositoryImpl
import kr.ohyung.data.repository.WeatherRepositoryImpl
import kr.ohyung.domain.repository.ReverseGeocodingRepository
import kr.ohyung.domain.repository.WeatherRepository
import kr.ohyung.domain.usecase.GetCurrentLocationForecastUseCase
import kr.ohyung.weather.main.MainViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Lee Oh Hyoung on 2020/07/09.
 */

private val appModules = module {

    // usecase
    factory { GetCurrentLocationForecastUseCase(get<WeatherRepository>(), get<ReverseGeocodingRepository>()) }

    // repository implementation
    single { WeatherRepositoryImpl(get<WeatherApi>()) as WeatherRepository }
    single { ReverseGeocodingRepositoryImpl(get<ReverseGeocodingApi>()) as ReverseGeocodingRepository }
}

private val viewModelModules = module {
    viewModel { MainViewModel(get<GetCurrentLocationForecastUseCase>()) }
}

private val apiModule = module {

    // retrofit service
    single { RetrofitManager.create(WeatherApi::class.java) as WeatherApi }
    single { RetrofitManager.create(ReverseGeocodingApi::class.java) as ReverseGeocodingApi }
}

val modules = listOf(appModules, viewModelModules, apiModule)
