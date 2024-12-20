package com.hong.mvvm

import com.hong.library.api.UserApi
import com.hong.library.api.beans.Articles
import com.hong.library.mvvm.BaseRepository
import com.hong.library.okhttp.RetrofitManager
import io.reactivex.Observable

class MainRepository : BaseRepository() {

    fun getTest(): Observable<Articles> {
        return request {
            RetrofitManager.instance.create(UserApi::class.java).test()
        }
    }
}