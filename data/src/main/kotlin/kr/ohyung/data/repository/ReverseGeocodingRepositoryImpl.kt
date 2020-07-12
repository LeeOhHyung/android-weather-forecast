/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.data.repository

import io.reactivex.Single
import kr.ohyung.data.network.api.ReverseGeocodingApi
import kr.ohyung.data.network.response.toEntity
import kr.ohyung.domain.entity.LocationLegalName
import kr.ohyung.domain.repository.ReverseGeocodingRepository

class ReverseGeocodingRepositoryImpl(
    private val reverseGeocodingApi: ReverseGeocodingApi
): ReverseGeocodingRepository {

    override fun getCurrentLegalName(lat: Double, lon: Double): Single<LocationLegalName> =
        reverseGeocodingApi.getLegalNameByLatLon(concatLatLonToCoords(lat, lon))
            .map {it.toEntity() }

    private fun concatLatLonToCoords(lat: Double, lon: Double): String =
        String.format("%s,%s", lon.toString(), lat.toString())
}
