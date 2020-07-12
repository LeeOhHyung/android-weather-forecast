/*
 * Created by Lee Oh Hyoung on 2020/07/12 .. 
 */
package kr.ohyung.data.network.response

import com.google.gson.annotations.SerializedName
import kr.ohyung.data.Response

data class NaverReverseGeocodingRegion(

    @SerializedName("area0") // 국가 코드
    val area0: NaverReverseGeocodingArea,

    @SerializedName("area1") // 특별시,광역시,도
    val area1: NaverReverseGeocodingArea,

    @SerializedName("area2") // 시군구
    val area2: NaverReverseGeocodingArea,

    @SerializedName("area3") // 읍면동
    val area3: NaverReverseGeocodingArea,

    @SerializedName("area4") // 리
    val area4: NaverReverseGeocodingArea
): Response
