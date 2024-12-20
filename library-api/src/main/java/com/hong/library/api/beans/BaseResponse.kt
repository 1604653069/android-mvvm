package com.hong.library.api.beans

data class BaseResponse<T>(
    val errorCode: Int,
    val errorMsg: String,
    val data: T
) {
    fun isSuccessful() = errorCode == 0
}