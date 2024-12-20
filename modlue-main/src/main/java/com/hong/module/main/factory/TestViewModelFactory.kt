package com.hong.module.main.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hong.module.main.repository.TestRepository
import com.hong.module.main.viewmodel.TestViewModel

class TestViewModelFactory:ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>)=
        TestViewModel(TestRepository()) as T
}