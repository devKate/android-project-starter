package com.katien.project.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.katien.project.model.Profile
import com.katien.project.repo.ProfileRepository
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class SearchViewModel
@Inject constructor(val profileRepository: ProfileRepository) : ViewModel() {
    val profile = MutableLiveData<Profile>()

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    fun loadProfile(username: String) {
        uiScope.launch {
            profile.value = profileRepository.getProfile(username)
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
