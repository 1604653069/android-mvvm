package com.hong.mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.hong.library.api.beans.Articles
import com.hong.library.mvvm.BaseViewModel
import com.hong.library.okhttp.addTo

class MainViewModel(model: MainRepository) : BaseViewModel<Any, MainRepository>(model) {

    private val _articleLiveData = MutableLiveData<Articles>()
    val articleLiveData: LiveData<Articles> = _articleLiveData

    fun getTest() =
        repository.getTest()
            .subscribe(
                { _articleLiveData.value = it },
                { _errorLiveData.value = it.message }
            )
            .addTo(compositeDisposable)
}