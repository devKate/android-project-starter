package com.katien.project.remote

import com.katien.project.model.Profile
import com.squareup.moshi.Json

data class UserRemote(
        @Json(name = "login") val login: String, // devKate
        @Json(name = "id") val id: Int, // 8015883
        @Json(name = "node_id") val nodeId: String, // MDQ6VXNlcjgwMTU4ODM=
        @Json(name = "avatar_url") val avatarUrl: String, // https://avatars3.githubusercontent.com/u/8015883?v=4
        @Json(name = "gravatar_id") val gravatarId: String,
        @Json(name = "url") val url: String, // https://api.github.com/users/devKate
        @Json(name = "html_url") val htmlUrl: String, // https://github.com/devKate
        @Json(name = "followers_url") val followersUrl: String, // https://api.github.com/users/devKate/followers
        @Json(name = "following_url") val followingUrl: String, // https://api.github.com/users/devKate/following{/other_user}
        @Json(name = "gists_url") val gistsUrl: String, // https://api.github.com/users/devKate/gists{/gist_id}
        @Json(name = "starred_url") val starredUrl: String, // https://api.github.com/users/devKate/starred{/owner}{/repo}
        @Json(name = "subscriptions_url") val subscriptionsUrl: String, // https://api.github.com/users/devKate/subscriptions
        @Json(name = "organizations_url") val organizationsUrl: String, // https://api.github.com/users/devKate/orgs
        @Json(name = "repos_url") val reposUrl: String, // https://api.github.com/users/devKate/repos
        @Json(name = "events_url") val eventsUrl: String, // https://api.github.com/users/devKate/events{/privacy}
        @Json(name = "received_events_url") val receivedEventsUrl: String, // https://api.github.com/users/devKate/received_events
        @Json(name = "type") val type: String, // User
        @Json(name = "site_admin") val siteAdmin: Boolean, // false
        @Json(name = "name") val name: String, // Katie Noland
        @Json(name = "company") val company: String, // Devetry
        @Json(name = "blog") val blog: String,
        @Json(name = "location") val location: String, // United States
        @Json(name = "email") val email: Any?, // null
        @Json(name = "hireable") val hireable: Boolean, // true
        @Json(name = "bio") val bio: Any?, // null
        @Json(name = "public_repos") val publicRepos: Int, // 6
        @Json(name = "public_gists") val publicGists: Int, // 0
        @Json(name = "followers") val followers: Int, // 7
        @Json(name = "following") val following: Int, // 1
        @Json(name = "created_at") val createdAt: String, // 2014-06-29T00:33:55Z
        @Json(name = "updated_at") val updatedAt: String // 2018-09-24T00:19:44Z

) {
    fun toLocal() = Profile(
            username = login,
            fullname = name,
            avatarUrl = avatarUrl,
            company = company,
            location = location
    )
}