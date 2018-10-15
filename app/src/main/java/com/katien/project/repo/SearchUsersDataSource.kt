package com.katien.project.repo

import androidx.paging.PageKeyedDataSource
import com.katien.project.model.UserSummary
import com.katien.project.remote.GithubService
import com.katien.project.remote.util.await
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject

class SearchUsersDataSource @Inject constructor(val service: GithubService) :
        PageKeyedDataSource<Int, UserSummary>() {
    lateinit var query: String

    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, UserSummary>) {
        CoroutineScope(Dispatchers.IO).launch {
            callback.onResult(service.searchUsers(query, 1).await()
                    .items.map { it.toLocal() }, 1, 2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, UserSummary>) {
        CoroutineScope(Dispatchers.IO).launch {
            callback.onResult(service.searchUsers(query, params.key).await()
                    .items.map { it.toLocal() }, params.key + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, UserSummary>) {}
}