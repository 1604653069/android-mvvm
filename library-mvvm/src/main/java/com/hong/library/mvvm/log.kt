package com.hong.library.mvvm

import android.util.Log

fun Any.log(message: String) {
    if (Constant.IS_DEBUG) {
        Log.d(this::class.java.simpleName, message)
    }
}