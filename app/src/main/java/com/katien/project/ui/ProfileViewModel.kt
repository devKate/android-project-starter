package com.katien.project.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.katien.project.model.Profile
import com.katien.project.repo.ProfileRepository
import kotlinx.coroutines.experimental.*
import javax.inject.Inject

class ProfileViewModel
@Inject constructor(val profileRepository: ProfileRepository) : ViewModel() {
    val profile = MutableLiveData<Profile>()

    private val job = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + job)

    fun loadProfile(username: String) {
        uiScope.launch {
            val result = withContext(Dispatchers.IO + job) {
                profileRepository.getProfile(username)
            }
            profile.value = result
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
