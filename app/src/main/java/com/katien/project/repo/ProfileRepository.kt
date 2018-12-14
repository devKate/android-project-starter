package com.katien.project.repo

import com.katien.project.model.Profile
import com.katien.project.remote.GithubService
import com.katien.project.remote.util.await

open class ProfileRepository(val githubService: GithubService) {

    suspend fun getProfile(username: String): Profile =
            githubService.getUser(username).await().toLocal()

}
