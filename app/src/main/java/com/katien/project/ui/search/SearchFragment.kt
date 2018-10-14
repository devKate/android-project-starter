package com.katien.project.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.katien.project.R
import com.katien.project.di.Injectable
import com.katien.project.model.UserSummary
import kotlinx.android.synthetic.main.search_fragment.*
import javax.inject.Inject

class SearchFragment : Fragment(), Injectable {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var viewModel: SearchViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.search_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders
                .of(this, viewModelFactory)
                .get(SearchViewModel::class.java)

        userRecyclerView.layoutManager = LinearLayoutManager(context)
        userRecyclerView.adapter = SearchListAdapter()

        // TODO: this should not require multiple LiveDatas
        var result: LiveData<PagedList<UserSummary>>? = null
        searchButton.setOnClickListener {
            userSearchLoadingIndicator.visibility = View.VISIBLE

            result?.removeObservers(this)

            result = viewModel.searchGithub(usernameInput.text.toString())
            result?.observe(this, Observer<PagedList<UserSummary>> {
                if (it != null)
                    (userRecyclerView.adapter as SearchListAdapter).submitList(it)

                userSearchLoadingIndicator.visibility = View.GONE
                userRecyclerView.visibility = View.VISIBLE
            })
        }
    }
}
