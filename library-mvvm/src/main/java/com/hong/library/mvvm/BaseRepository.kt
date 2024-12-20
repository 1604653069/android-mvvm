package com.hong.library.mvvm

import com.hong.library.api.beans.BaseResponse
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

open class BaseRepository {

    private fun <T> observeAt(observable: Observable<T>): Observable<T> {
        return observable
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun <T> observeFg(observable: Observable<T>): Observable<T> {
        return observable.subscribeOn(Schedulers.io())
            .unsubscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    private fun <T, R> request(
        observable: Observable<BaseResponse<T>>,
        successMapper: (T) -> R
    ): Observable<R> {
        return observeAt(observable).processApiResponse(successMapper)
    }

    protected fun <T> request(block:() -> Observable<BaseResponse<T>>): Observable<T> {
        return request(block()) { it }
    }

}