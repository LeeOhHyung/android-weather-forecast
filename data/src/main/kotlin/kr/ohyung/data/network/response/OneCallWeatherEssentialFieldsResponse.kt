/*
 * Created by Lee Oh Hyoung on 2020/07/12 .. 
 */
package kr.ohyung.data.network.response

import com.google.gson.annotations.SerializedName

open class OneCallWeatherEssentialFieldsResponse {

    @SerializedName("pressure")
    val pressure: Int = Int.MAX_VALUE

    @SerializedName("humidity")
    val humidity: Int = Int.MAX_VALUE

    @SerializedName("dew_point")
    val dewPoint: Double = Double.MAX_VALUE

    @SerializedName("uvi")
    val uvi: Double = Double.MAX_VALUE

    @SerializedName("clouds")
    val clouds: Int = Int.MAX_VALUE

    @SerializedName("visibility") // 가시거리
    val visibility: Int? = null

    @SerializedName("wind_speed")
    val windSpeed: Double = Double.MAX_VALUE

    @SerializedName("wind_deg")
    val windDeg: Int = Int.MAX_VALUE

}