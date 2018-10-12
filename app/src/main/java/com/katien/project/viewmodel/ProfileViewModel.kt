package com.katien.project.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.katien.project.model.Profile
import com.katien.project.repo.ProfileRepository
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class ProfileViewModel
@Inject constructor(val profileRepository: ProfileRepository) : ViewModel() {
     val profile = MutableLiveData<Profile>()
//    val profile: LiveDataa<ConsumableValue<Profile>> = Transformations.map(_profile) { ConsumableValue(it) }


    private val viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    fun loadProfile(username: String) {
        uiScope.launch {
                profile.value=  profileRepository.getProfile(username)

        }
    }
}
