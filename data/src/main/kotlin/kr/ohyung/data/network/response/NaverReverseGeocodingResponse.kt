/*
 * Created by Lee Oh Hyoung on 2020/07/12 .. 
 */
package kr.ohyung.data.network.response

import com.google.gson.annotations.SerializedName
import kr.ohyung.data.Response
import kr.ohyung.domain.entity.LocationLegalName
import kr.ohyung.domain.exception.LocationNotFoundException

data class NaverReverseGeocodingResponse(

    @SerializedName("status")
    val status: NaverReverseGeocodingStatus,

    @SerializedName("results")
    val results: List<NaverReverseGeocodingResult>
) : Response

fun NaverReverseGeocodingResponse.toEntity(): LocationLegalName =
    results.firstOrNull { it.name == "legalcode" }
        ?.let {  result ->
            LocationLegalName(
                id = result.code.id.toLong(),
                latitude = result.region.area3.coords.center.latitude,
                longitude = result.region.area3.coords.center.longitude,
                countryCode = result.region.area0.name,
                city = String.format("%s %s %s", result.region.area1, result.region.area2, result.region.area3)
            )
        }
        ?: throw LocationNotFoundException("legalName of Location cannot found")
