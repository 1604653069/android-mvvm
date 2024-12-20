package com.hong.library.api

import com.hong.library.api.beans.Articles
import com.hong.library.api.beans.BaseResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface UserApi {


    @GET("article/list/0/json")
    fun test():Observable<BaseResponse<Articles>>
}