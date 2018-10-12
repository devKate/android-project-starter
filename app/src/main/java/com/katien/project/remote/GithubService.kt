package com.katien.project.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {
    @GET("users/{username}")
    fun getUser(@Path("username") userName: String): Call<UserRemote>

    @GET("search/users")
    fun searchUsers(@Query("q") userName: String): Call<SearchUsersRemote>

}
