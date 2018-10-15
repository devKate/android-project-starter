package com.katien.project.remote.model

import com.katien.project.model.UserSummary
import com.squareup.moshi.Json


data class SearchUsersRemote(
        @Json(name = "total_count") val totalCount: Int?,
        @Json(name = "incomplete_results") val incompleteResults: Boolean?,
        @Json(name = "items") val items: List<Item>
)

data class Item(
        @Json(name = "login") val login: String?,
        @Json(name = "avatar_url") val avatarUrl: String?
) {
    fun toLocal() =
            UserSummary(username = login ?: "", avatarUrl = avatarUrl ?: "")
}