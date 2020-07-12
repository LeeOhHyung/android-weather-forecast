/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.domain.entity

import kr.ohyung.domain.Entity

data class Forecast(
    val country: String,
    val city: String,
    val current: Weather,
    val hourly: List<Weather>,
    val daily: List<Weather>
): Entity
