/*
 * Created by Lee Oh Hyoung on 2020/07/11 .. 
 */
package kr.ohyung.domain.entity

import kr.ohyung.domain.Entity

data class LocationLegalName(
    val id: Long,
    val latitude: Double,
    val longitude: Double,
    val countryCode: String,
    val city: String
): Entity
