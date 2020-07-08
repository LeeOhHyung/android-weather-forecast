package kr.ohyung.domain.repository

import io.reactivex.Single
import kr.ohyung.domain.Repository
import kr.ohyung.domain.entity.MockEntity

/**
 * Created by Lee Oh Hyoung on 2020/07/09.
 */
interface MockRepository : Repository {

    fun mock(): Single<MockEntity>
}
