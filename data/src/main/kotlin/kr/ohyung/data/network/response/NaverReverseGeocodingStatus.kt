/*
 * Created by Lee Oh Hyoung on 2020/07/12 .. 
 */
package kr.ohyung.data.network.response

import com.google.gson.annotations.SerializedName
import kr.ohyung.data.Response

data class NaverReverseGeocodingStatus(

    @SerializedName("code")
    val code: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("message")
    val message: String
): Response