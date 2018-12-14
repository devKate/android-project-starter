package com.katien.project.ui.profile

import com.katien.project.di.appModule
import com.katien.project.model.Profile
import com.katien.project.repo.ProfileRepository
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.experimental.runBlocking
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import org.koin.test.AutoCloseKoinTest
import org.koin.test.declareMock

@RunWith(JUnit4::class)
class ProfileViewModelTest: AutoCloseKoinTest() {

    private val mockRepo: ProfileRepository by inject()

    private lateinit var viewModel: ProfileViewModel

    private val testProfile = Profile("user", "url", "full name", "company", "location")

    @Before
    fun setUp() = runBlocking {
        startKoin(listOf(appModule))
        declareMock<ProfileRepository>()

        whenever(mockRepo.getProfile(any())).thenReturn(testProfile)

        viewModel = ProfileViewModel(mockRepo)
    }

    @Test
    fun fetchProfile() = runBlocking {
        val model = viewModel.fetchProfile("username")

        verify(mockRepo).getProfile("username")

        assertThat(model).isEqualToComparingFieldByField(testProfile)
        return@runBlocking
    }
}