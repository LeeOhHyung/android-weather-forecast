/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.data.network.response.daily

import com.google.gson.annotations.SerializedName
import kr.ohyung.data.Response

data class OneCallDailyFeelsLikeResponse(

    @SerializedName("day")
    val day: Double,

    @SerializedName("night")
    val night: Double,

    @SerializedName("eve")
    val eve: Double,

    @SerializedName("morn")
    val morn: Double
): Response