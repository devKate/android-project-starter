package com.katien.project.repo

import com.katien.project.model.Profile
import com.katien.project.remote.GithubService
import com.katien.project.remote.SearchUsersRemote
import com.katien.project.remote.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileRepository @Inject constructor(
        private val githubService: GithubService
) {
    suspend fun searchGithub(query: String): SearchUsersRemote {
        val response = githubService.searchUsers(query).await()

        return response
    }

    suspend fun getProfile(username: String): Profile {
        val response = githubService.getUser(username).await()
        return response.toLocal()
    }
}
