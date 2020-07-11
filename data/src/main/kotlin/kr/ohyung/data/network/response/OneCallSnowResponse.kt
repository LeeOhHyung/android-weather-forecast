/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.data.network.response

import com.google.gson.annotations.SerializedName
import kr.ohyung.data.Response

data class OneCallSnowResponse(

    @SerializedName("1h")
    val hourPer1: Double?
): Response
