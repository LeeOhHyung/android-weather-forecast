/*
 * Created by Lee Oh Hyoung on 2020/07/12 .. 
 */
package kr.ohyung.data.network.response

import kr.ohyung.data.Response

abstract class OneCallWeatherEssentialFieldsResponse : Response {
    abstract val pressure: Int
    abstract val humidity: Int
    abstract val dewPoint: Double
    abstract val uvi: Double
    abstract val clouds: Int
    abstract val visibility: Int?
    abstract val windSpeed: Double
    abstract val windDeg: Int
}
