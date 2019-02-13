package com.katien.project.remote

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.katien.project.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun getMoshiConverterFactory() = MoshiConverterFactory.create(Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build())

fun getLoggingInterceptor() = HttpLoggingInterceptor()
        .apply {
            level = if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
        }

fun getOkHttpClient(vararg interceptors: Interceptor): OkHttpClient {
    val client = OkHttpClient.Builder()

    interceptors.forEach {
        client.interceptors().add(it)
    }
    return client.build()
}


fun getService(): GithubService {
    return Retrofit.Builder()
            .baseUrl(BuildConfig.API_URL)
            .addConverterFactory(getMoshiConverterFactory())
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(getOkHttpClient(getLoggingInterceptor()))
            .build()
            .create(GithubService::class.java)
}