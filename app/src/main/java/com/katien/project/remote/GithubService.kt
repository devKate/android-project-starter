package com.katien.project.remote

import com.katien.project.remote.model.SearchUsersRemote
import com.katien.project.remote.model.UserRemote
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubService {
    companion object {
        val PAGE_SIZE = 20
    }

    @GET("users/{username}")
    fun getUser(@Path("username") userName: String): Call<UserRemote>

    @GET("search/users")
    fun searchUsers(@Query("q") query: String,
                    @Query("page") page: Int,
                    @Query("per_page") per_page: Int = PAGE_SIZE
    ): Call<SearchUsersRemote>
}
