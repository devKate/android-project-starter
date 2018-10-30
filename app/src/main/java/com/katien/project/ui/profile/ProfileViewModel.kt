package com.katien.project.ui.profile

import androidx.lifecycle.ViewModel
import com.katien.project.model.Profile
import com.katien.project.repo.ProfileRepository

class ProfileViewModel(val profileRepository: ProfileRepository) : ViewModel() {
    suspend fun fetchProfile(username: String): Profile {
        return profileRepository.getProfile(username)
    }
}
