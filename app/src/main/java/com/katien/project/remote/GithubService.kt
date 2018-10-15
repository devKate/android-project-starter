package com.katien.project.remote

import com.katien.project.remote.model.UserRemote
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{username}")
    fun getUser(@Path("username") userName: String): Call<UserRemote>
}
