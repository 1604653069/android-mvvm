package com.hong.module.main

import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.facade.annotation.Route
import com.hong.library.mvvm.BaseMvvmActivity
import com.hong.module.main.databinding.ActivityTestBinding
import com.hong.module.main.factory.TestViewModelFactory
import com.hong.module.main.viewmodel.TestViewModel

@Route(path = "/test/TestActivity")
class TestActivity: BaseMvvmActivity<TestViewModel, ActivityTestBinding>() {

    override fun logic() {

    }

    override fun observable() {

    }

    override fun createViewModel() = ViewModelProvider(this,TestViewModelFactory())[
            TestViewModel::class.java
    ]
}