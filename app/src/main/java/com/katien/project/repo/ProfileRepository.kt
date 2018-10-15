package com.katien.project.repo

import com.katien.project.model.Profile
import com.katien.project.remote.GithubService
import com.katien.project.remote.util.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileRepository @Inject constructor(val githubService: GithubService) {

    suspend fun getProfile(username: String): Profile =
            githubService.getUser(username).await().toLocal()

}
