package com.katien.project.remote

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.experimental.suspendCoroutine


suspend fun <T> Call<T>.await(): T {
    return suspendCoroutine {
        enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>, t: Throwable) =
                    it.resumeWithException(t)


            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful)
                    it.resume(response.body()!!)
                else
                    it.resumeWithException(Exception(response.errorBody().toString()))
            }
        })
    }
}
