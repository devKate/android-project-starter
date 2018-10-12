package com.katien.project.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.katien.project.viewmodel.GithubViewModelFactory
import com.katien.project.viewmodel.ProfileViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {


    @Binds
    @IntoMap
    @ViewModelKey(ProfileViewModel::class)
    abstract fun bindUserViewModel(profileViewModel: ProfileViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: GithubViewModelFactory): ViewModelProvider.Factory
}
