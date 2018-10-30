@file:Suppress("RemoveExplicitTypeArguments")

package com.katien.project.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.katien.project.BuildConfig
import com.katien.project.remote.GithubService
import com.katien.project.repo.ProfileRepository
import com.katien.project.ui.SplashViewModel
import com.katien.project.ui.profile.ProfileViewModel
import com.katien.project.ui.search.SearchViewModel
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

var appModule = module {

    single<GithubService> {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG)
            HttpLoggingInterceptor.Level.BODY
        else
            HttpLoggingInterceptor.Level.NONE

        val client = OkHttpClient.Builder()
        client.interceptors().add(logging)

        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(client.build())
                .build()
                .create(GithubService::class.java)
    }

    single<ProfileRepository> { ProfileRepository(get()) }
}

var viewModelModule = module {

    viewModel { ProfileViewModel(get()) }
    viewModel { SearchViewModel() }
    viewModel { SplashViewModel() }

}