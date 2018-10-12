package com.katien.project.di

import com.katien.project.ui.ProfileFragment
import com.katien.project.ui.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): ProfileFragment
    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment
}
