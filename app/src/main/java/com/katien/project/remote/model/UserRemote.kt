package com.katien.project.remote.model

import com.katien.project.model.Profile
import com.squareup.moshi.Json


data class UserRemote(
        @Json(name = "login") val login: String?,
        @Json(name = "avatar_url") val avatarUrl: String?,
        @Json(name = "name") val name: String?,
        @Json(name = "company") val company: String?,
        @Json(name = "blog") val blog: String?,
        @Json(name = "location") val location: String?,
        @Json(name = "email") val email: String?,
        @Json(name = "hireable") val hireable: Boolean?,
        @Json(name = "bio") val bio: String?
) {
    fun toLocal() = Profile(
            username = login ?: "",
            fullName = name ?: "",
            avatarUrl = avatarUrl ?: "",
            company = company ?: "",
            location = location ?: ""
    )
}