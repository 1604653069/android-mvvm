package com.hong.library.mvvm

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.viewbinding.ViewBinding

abstract class FullActivity<VM:BaseViewModel<*,*>,VB: ViewBinding> : BaseMvvmActivity<VM, VB>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.statusBarColor = Color.TRANSPARENT
        }
        super.onCreate(savedInstanceState)
    }
}