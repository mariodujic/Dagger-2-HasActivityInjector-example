package com.groundzero.legoproject.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

fun <T> resultLiveData(networkCall: suspend () -> Result<T>): LiveData<Result<T>> =
    liveData(Dispatchers.IO) {
        emit(Result.loading())
        val responseStatus = networkCall.invoke()
        if (responseStatus.status == Result.Status.SUCCESS) {
            Result.success(responseStatus.data!!)
            val source = Result.success(responseStatus.data!!)
            emit(source)
        } else if (responseStatus.status == Result.Status.ERROR) {
            emit(Result.error(responseStatus.message!!))
        }
    }