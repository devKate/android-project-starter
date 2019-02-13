package com.katien.project.di

import androidx.room.Room
import com.katien.project.db.ProfileDao
import com.katien.project.db.AppDb
import com.katien.project.remote.GithubService
import com.katien.project.remote.getService
import com.katien.project.repo.ProfileRepository
import com.katien.project.sharedprefs.SharedPrefs
import com.katien.project.ui.SplashViewModel
import com.katien.project.ui.profile.ProfileViewModel
import com.katien.project.ui.search.SearchViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

var appModule = module {

    // remote
    single<GithubService> { getService() }

    // db
    single<ProfileDao> { get<AppDb>().profileDao() }

    single<AppDb> {
        Room.databaseBuilder(androidApplication(), AppDb::class.java, AppDb.APP_DATABASE)
                .fallbackToDestructiveMigration()
                .build()
    }

    single<SharedPrefs> { SharedPrefs(androidApplication()) }

    // repo
    single<ProfileRepository> { ProfileRepository(get()) }
}

var viewModelModule = module {
    viewModel { SplashViewModel() }
    viewModel { SearchViewModel() }
    viewModel { ProfileViewModel(get()) }
}