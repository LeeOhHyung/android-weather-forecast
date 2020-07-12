/*
 * Created by Lee Oh Hyoung on 2020/07/12 .. 
 */
package kr.ohyung.weather.main

import kr.ohyung.weather.UiState

sealed class MainUiState : UiState {

    object Loading: MainUiState()

    data class Content(
        val country: String,
        val city: String,
        val latitude: String,
        val longitude: String,
        val currentDate: String,
        val currentTemp: String,
        val pressure: String,
        val humidity: String,
        val uvi: String,
        val clouds: String,
        val visibility: String,
        val windKmh: String,
        val rain: String,
        val snow: String,
        val weatherName: String,
        val weatherIcon: String
    ): MainUiState()

    data class Error(
        val errorCode: String,
        val errorMessage: String,
        val throwable: Throwable?
    ): MainUiState()
}
