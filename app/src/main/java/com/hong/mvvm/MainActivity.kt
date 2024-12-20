package com.hong.mvvm

import androidx.lifecycle.ViewModelProvider
import com.alibaba.android.arouter.launcher.ARouter
import com.hong.library.mvvm.BaseMvvmActivity
import com.hong.library.mvvm.log
import com.hong.mvvm.databinding.ActivityMainBinding

class MainActivity : BaseMvvmActivity<MainViewModel, ActivityMainBinding>() {

    override fun logic() {
        viewModel.getTest()
        binding.button.setOnClickListener {
           ARouter.getInstance().build("/test/TestActivity").navigation()
        }
    }

    override fun observable() {
        viewModel.articleLiveData.observe(this) {
            for (article in it.datas) {
                log(article.title)
            }
        }
    }

    override fun createViewModel() = ViewModelProvider(this, MainViewModelFactory())[
            MainViewModel::class.java
    ]
}