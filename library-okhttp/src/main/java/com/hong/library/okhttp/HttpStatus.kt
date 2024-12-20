package com.hong.library.okhttp

class HttpStatus(val success: Boolean, val errorCode: Int, val errorMsg: String) {

    fun isCodeInvalid() = errorCode == 0
}