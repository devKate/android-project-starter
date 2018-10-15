package com.katien.project.di

import com.katien.project.ui.profile.ProfileFragment
import com.katien.project.ui.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentModule {
    @ContributesAndroidInjector
    abstract fun contributeMainFragment(): ProfileFragment

    @ContributesAndroidInjector
    abstract fun contributeSearchFragment(): SearchFragment
}
