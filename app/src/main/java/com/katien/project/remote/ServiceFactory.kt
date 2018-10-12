package com.katien.project.remote

import com.katien.project.BuildConfig
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object ServiceFactory {
    fun createRetrofit() {
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

    }


}