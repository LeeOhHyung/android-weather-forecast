package kr.ohyung.domain.usecase

import io.reactivex.disposables.CompositeDisposable
import kr.ohyung.domain.UseCase

/**
 * Created by Lee Oh Hyoung on 2020/07/09.
 */
abstract class BaseUseCase : UseCase {

    protected val compositeDisposable = CompositeDisposable()

    protected fun dispose() {
        if(compositeDisposable.isDisposed.not()){
            compositeDisposable.dispose()
        }
    }

    protected fun clear() {
        compositeDisposable.clear()
    }

}
