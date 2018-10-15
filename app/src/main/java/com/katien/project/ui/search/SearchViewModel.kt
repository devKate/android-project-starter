package com.katien.project.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.katien.project.model.UserSummary
import com.katien.project.repo.ProfileRepository
import javax.inject.Inject

class SearchViewModel
@Inject constructor(val profileRepository: ProfileRepository) : ViewModel() {

    fun searchGithub(query: String): LiveData<PagedList<UserSummary>> {
        return profileRepository.searchGithub(query)
    }
}
