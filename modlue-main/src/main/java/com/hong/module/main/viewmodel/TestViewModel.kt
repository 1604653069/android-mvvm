package com.hong.module.main.viewmodel

import com.hong.library.mvvm.BaseViewModel
import com.hong.module.main.repository.TestRepository

class TestViewModel(model: TestRepository) : BaseViewModel<Any, TestRepository>(model) {
}