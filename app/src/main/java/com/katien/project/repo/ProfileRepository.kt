package com.katien.project.repo

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.katien.project.model.Profile
import com.katien.project.model.UserSummary
import com.katien.project.remote.GithubService
import com.katien.project.remote.GithubService.Companion.PAGE_SIZE
import com.katien.project.remote.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileRepository @Inject constructor(
        val githubService: GithubService,
        val dataSourceFactory: SearchUsersDataSourceFactory
) {

    fun searchGithub(query: String): LiveData<PagedList<UserSummary>> {
        // TODO: find a cleaner way to update the query
        dataSourceFactory.dataSource.query = query
        return LivePagedListBuilder(dataSourceFactory, PAGE_SIZE)
                .build()
    }

    suspend fun getProfile(username: String): Profile {
        val response = githubService.getUser(username).await()
        return response.toLocal()
    }
}
