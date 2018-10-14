package com.katien.project.repo

import androidx.paging.DataSource
import com.katien.project.model.UserSummary
import javax.inject.Inject

class SearchUsersDataSourceFactory @Inject constructor(val dataSource: SearchUsersDataSource) :
        DataSource.Factory<Int, UserSummary>() {

    override fun create(): DataSource<Int, UserSummary> = dataSource
}