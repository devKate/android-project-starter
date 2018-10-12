package com.katien.project.remote

import kotlinx.coroutines.experimental.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("users/{username}")
    fun getUser(@Path("username") userName: String): Deferred<Response<UserRemote>>

}
