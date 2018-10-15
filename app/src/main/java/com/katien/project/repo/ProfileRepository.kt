package com.katien.project.repo

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.katien.project.model.Profile
import com.katien.project.model.UserSummary
import com.katien.project.remote.GithubService
import com.katien.project.remote.GithubService.Companion.PAGE_SIZE
import com.katien.project.remote.util.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProfileRepository @Inject constructor(
        val githubService: GithubService,
        val dataSourceFactory: SearchUsersDataSourceFactory
) {

    fun searchGithub(query: String): LiveData<PagedList<UserSummary>> {
        dataSourceFactory.dataSource.query = query
        return LivePagedListBuilder(dataSourceFactory, PAGE_SIZE)
                .build()
    }

    suspend fun getProfile(username: String): Profile =
            githubService.getUser(username).await().toLocal()
}
