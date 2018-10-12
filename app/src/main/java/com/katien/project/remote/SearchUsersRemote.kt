package com.katien.project.remote

import com.squareup.moshi.Json


data class SearchUsersRemote(
        @Json(name = "total_count") val totalCount: Int, // 9
        @Json(name = "incomplete_results") val incompleteResults: Boolean, // false
        @Json(name = "items") val items: List<UserSummaryRemote>
)

data class UserSummaryRemote(
        @Json(name = "login") val login: String, // Kirandevkate
        @Json(name = "id") val id: Int, // 14819232
        @Json(name = "node_id") val nodeId: String, // MDQ6VXNlcjE0ODE5MjMy
        @Json(name = "avatar_url") val avatarUrl: String, // https://avatars2.githubusercontent.com/u/14819232?v=4
        @Json(name = "gravatar_id") val gravatarId: String,
        @Json(name = "url") val url: String, // https://api.github.com/users/Kirandevkate
        @Json(name = "html_url") val htmlUrl: String, // https://github.com/Kirandevkate
        @Json(name = "followers_url") val followersUrl: String, // https://api.github.com/users/Kirandevkate/followers
        @Json(name = "following_url") val followingUrl: String, // https://api.github.com/users/Kirandevkate/following{/other_user}
        @Json(name = "gists_url") val gistsUrl: String, // https://api.github.com/users/Kirandevkate/gists{/gist_id}
        @Json(name = "starred_url") val starredUrl: String, // https://api.github.com/users/Kirandevkate/starred{/owner}{/repo}
        @Json(name = "subscriptions_url") val subscriptionsUrl: String, // https://api.github.com/users/Kirandevkate/subscriptions
        @Json(name = "organizations_url") val organizationsUrl: String, // https://api.github.com/users/Kirandevkate/orgs
        @Json(name = "repos_url") val reposUrl: String, // https://api.github.com/users/Kirandevkate/repos
        @Json(name = "events_url") val eventsUrl: String, // https://api.github.com/users/Kirandevkate/events{/privacy}
        @Json(name = "received_events_url") val receivedEventsUrl: String, // https://api.github.com/users/Kirandevkate/received_events
        @Json(name = "type") val type: String, // User
        @Json(name = "site_admin") val siteAdmin: Boolean, // false
        @Json(name = "score") val score: Double // 13.917266
)