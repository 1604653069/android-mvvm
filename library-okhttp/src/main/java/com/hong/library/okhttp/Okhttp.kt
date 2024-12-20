package com.hong.library.okhttp

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

object Okhttp {
    private const val WRITE_TIME_OUT = 15L
    private const val READ_TIME_OUT = 15L
    private const val CONNECT_TIME_OUT = 15L
    val okHttpClient: OkHttpClient by lazy { okhttpClient() }

    private fun okhttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .writeTimeout(WRITE_TIME_OUT,TimeUnit.SECONDS)
            .readTimeout(READ_TIME_OUT,TimeUnit.SECONDS)
            .connectTimeout(CONNECT_TIME_OUT,TimeUnit.SECONDS)
            .addInterceptor(logging).build()
    }
}