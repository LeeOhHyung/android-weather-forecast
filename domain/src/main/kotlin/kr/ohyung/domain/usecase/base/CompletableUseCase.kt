package kr.ohyung.domain.usecase.base

import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.rxkotlin.addTo
import kr.ohyung.domain.usecase.base.BaseUseCase

/**
 * Created by Lee Oh Hyoung on 2020/07/09.
 */
abstract class CompletableUseCase(
    private val executorScheduler: Scheduler,
    private val postExecutionScheduler: Scheduler
) : BaseUseCase() {

    protected abstract fun buildUseCaseCompletable(): Completable

    fun execute(observer: DisposableCompletableObserver) {
        if(compositeDisposable.isDisposed.not()) {
            buildUseCaseCompletable()
                .subscribeOn(executorScheduler)
                .observeOn(postExecutionScheduler)
                .subscribeWith(observer)
                .addTo(compositeDisposable)
        }
    }
}
