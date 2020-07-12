package kr.ohyung.domain.usecase.base

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.rxkotlin.addTo

/**
 * Created by Lee Oh Hyoung on 2020/07/09.
 */
abstract class SingleUseCase<T, in Params>(
    private val executorScheduler: Scheduler,
    private val postExecutionScheduler: Scheduler
) : BaseUseCase<Params>() {

    protected abstract fun buildUseCaseSingle(params: Params): Single<T>

    override fun execute(params: Params): Single<T> =
        buildUseCaseSingle(params = params)
            .subscribeOn(executorScheduler)
            .observeOn(postExecutionScheduler)
}
