package com.hong.library.mvvm

import com.hong.library.api.beans.BaseResponse
import io.reactivex.Observable

fun <T, R> Observable<BaseResponse<T>>.processApiResponse(successMapper: (T) -> R): Observable<R> {
    return flatMap { response ->
        if (response.isSuccessful()) {
            Observable.just(successMapper(response.data))
        } else {
            Observable.error(RuntimeException(response.errorMsg))
        }
    }
}