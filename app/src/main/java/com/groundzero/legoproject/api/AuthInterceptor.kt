package com.groundzero.legoproject.api

import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().addHeader(
            "Authorization", "key ${LegoApi.API_KEY}"
        ).build()
        return chain.proceed(request)
    }

}