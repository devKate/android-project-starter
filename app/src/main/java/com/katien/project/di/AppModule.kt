package com.katien.project.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.katien.project.BuildConfig
import com.katien.project.remote.GithubService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton


@Module(includes = [ViewModelModule::class])
class AppModule {
    @Singleton
    @Provides
    fun providesGitHubService(): GithubService {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val client = OkHttpClient.Builder()
        client.interceptors().add(logging)

        val moshi = Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()

        return Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(MoshiConverterFactory.create(moshi))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .client(client.build())
                .build()
                .create(GithubService::class.java)
    }
}
