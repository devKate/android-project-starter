package com.katien.project.remote

import com.katien.project.model.Profile
import com.squareup.moshi.Json

data class UserRemote(
        @Json(name = "login") val login: String, // devKate
//        @Json(name = "avatar_url") val avatarUrl: String = "", // https://avatars3.githubusercontent.com/u/8015883?v=4
        @Json(name = "name") val name: String, // Katie Noland
        @Json(name = "company") val company: String, // Devetry
        @Json(name = "blog") val blog: String,
        @Json(name = "location") val location: String, // United States
        @Json(name = "email") val email: Any, // null
        @Json(name = "hireable") val hireable: Boolean, // true
        @Json(name = "bio") val bio: Any, // null
        @Json(name = "public_repos") val publicRepos: Int, // 5
        @Json(name = "public_gists") val publicGists: Int, // 0
        @Json(name = "followers") val followers: Int, // 6
        @Json(name = "following") val following: Int // 1
) {
    fun toLocal() = Profile(
            username = login,
            fullname = name,
            company = company,
            location = location
    )
}