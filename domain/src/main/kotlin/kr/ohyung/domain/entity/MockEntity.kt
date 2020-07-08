package kr.ohyung.domain.entity

import kr.ohyung.domain.Entity

/**
 * Created by Lee Oh Hyoung on 2020/07/09.
 */
data class MockEntity(
    val id: Int,
    val title: String,
    val description: String
) : Entity
