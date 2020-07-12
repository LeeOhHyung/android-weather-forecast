/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.data.network.api

import io.reactivex.Single
import kr.ohyung.data.Api
import kr.ohyung.data.network.response.NaverReverseGeocodingResponse
import kr.ohyung.domain.entity.OutputUnit
import retrofit2.http.GET
import retrofit2.http.Query

interface ReverseGeocodingApi : Api {

    @GET("gc")
    fun getLegalNameByLatLon(
        @Query("coords") coords: String, // 경도, 위도
        @Query("output") output: String = OutputUnit.JSON.value
    ): Single<NaverReverseGeocodingResponse>
}
