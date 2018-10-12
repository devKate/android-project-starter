package com.katien.project.repo

import com.katien.project.model.Profile
import com.katien.project.remote.GithubService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileRepository @Inject constructor(
        private val githubService: GithubService
) {
    suspend fun getProfile(username: String):  Profile {
        val response = githubService.getUser(username).await()

        return if (response.isSuccessful)
              response.body()!!.toLocal()
        else
            throw Exception(response.errorBody().toString())
    }
}
