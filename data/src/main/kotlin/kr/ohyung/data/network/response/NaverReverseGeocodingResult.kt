/*
 * Created by Lee Oh Hyoung on 2020/07/12 .. 
 */
package kr.ohyung.data.network.response

import com.google.gson.annotations.SerializedName
import kr.ohyung.data.Response

data class NaverReverseGeocodingResult(

    @SerializedName("name")
    val name: String,

    @SerializedName("code")
    val code: CodeResponse,

    @SerializedName("region")
    val region: NaverReverseGeocodingRegion
): Response {

    data class CodeResponse(

        @SerializedName("id")
        val id: String,

        @SerializedName("type")
        val type: String,

        @SerializedName("mappingId")
        val mappingId: String
    ): Response
}
