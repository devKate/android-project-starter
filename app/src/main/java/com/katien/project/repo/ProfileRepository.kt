package com.katien.project.repo

import com.katien.project.model.Profile
import com.katien.project.remote.GithubService
import com.katien.project.remote.UserRemote
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.experimental.suspendCoroutine

@Singleton
class ProfileRepository @Inject constructor(
        private val githubService: GithubService
) {
    suspend fun getProfile(username: String): Profile {
        return suspendCoroutine {
            githubService.getUser(username)
                    .enqueue(object : Callback<UserRemote> {
                        override fun onFailure(call: Call<UserRemote>, t: Throwable) {
                            it.resumeWithException(t)
                        }

                        override fun onResponse(call: Call<UserRemote>, response: Response<UserRemote>) {
                            if (response.isSuccessful)
                                it.resume(response.body()!!.toLocal())
                            else
                                it.resumeWithException(Exception(response.errorBody().toString()))
                        }
                    })
        }
    }
}
