package kr.ohyung.domain.usecase.base

import kr.ohyung.domain.UseCase

/**
 * Created by Lee Oh Hyoung on 2020/07/09.
 */
abstract class BaseUseCase<in Params> : UseCase {

    abstract fun execute(params: Params): Any

}
