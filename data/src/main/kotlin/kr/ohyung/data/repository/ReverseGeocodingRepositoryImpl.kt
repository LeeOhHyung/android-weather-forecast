/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.data.repository

import io.reactivex.Single
import kr.ohyung.data.network.api.ReverseGeocodingApi
import kr.ohyung.domain.entity.LocationLegalName
import kr.ohyung.domain.repository.ReverseGeocodingRepository

class ReverseGeocodingRepositoryImpl(
    private val reverseGeocodingApi: ReverseGeocodingApi
): ReverseGeocodingRepository {

    override fun getCurrentLegalName(lat: Double, lon: Double): Single<LocationLegalName> =
        throw NotImplementedError()
}
