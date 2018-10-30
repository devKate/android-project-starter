package com.katien.project

import android.app.Application
import com.katien.project.di.appModule
import com.katien.project.di.viewModelModule
import org.koin.android.ext.android.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, listOf(
                appModule,
                viewModelModule
        ))
    }
}
