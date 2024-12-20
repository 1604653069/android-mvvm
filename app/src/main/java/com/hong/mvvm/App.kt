package com.hong.mvvm

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

class App:Application() {

    override fun onCreate() {
        super.onCreate()
        if (ARouter.debuggable()) {
            ARouter.openLog()
            ARouter.openDebug()
        }
        ARouter.init(this)
    }
}