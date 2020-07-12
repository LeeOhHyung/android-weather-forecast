/*
 * Created by Lee Oh Hyoung on 2020/07/12 .. 
 */
package kr.ohyung.data.network.response

import com.google.gson.annotations.SerializedName
import kr.ohyung.data.Response

data class NaverReverseGeocodingArea(

    @SerializedName("name")
    val name: String,

    @SerializedName("coords")
    val coords: CoordsResponse
): Response {

    data class CoordsResponse(

        @SerializedName("center")
        val center: CenterResponse
    ): Response {

        data class CenterResponse(

            @SerializedName("crs")
            val crs: String,

            @SerializedName("x") // 경도(longitude)
            val longitude: Double,

            @SerializedName("y") // 위도(latitude)
            val latitude: Double
        ): Response
    }
}