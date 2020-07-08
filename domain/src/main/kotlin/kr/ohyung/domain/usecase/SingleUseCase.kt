package kr.ohyung.domain.usecase

import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.rxkotlin.addTo

/**
 * Created by Lee Oh Hyoung on 2020/07/09.
 */
abstract class SingleUseCase<T>(
    private val executorScheduler: Scheduler,
    private val postExecutionScheduler: Scheduler
) : BaseUseCase() {

    protected abstract fun buildUseCaseSingle(): Single<T>

    fun execute(observer: DisposableSingleObserver<T>) {
        if(compositeDisposable.isDisposed.not())
            buildUseCaseSingle()
                .subscribeOn(executorScheduler)
                .observeOn(postExecutionScheduler)
                .subscribeWith(observer)
                .addTo(compositeDisposable)
    }
}
