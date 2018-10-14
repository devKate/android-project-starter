package com.katien.project.ui.search

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.katien.project.GlideApp
import com.katien.project.R
import com.katien.project.model.UserSummary
import kotlinx.android.synthetic.main.user_item.view.*

class SearchListAdapter(val itemClickListener: (UserSummary) -> Unit) : PagedListAdapter<UserSummary, SearchListAdapter.UserViewHolder>(USER_COMPARATOR) {

    companion object {
        val USER_COMPARATOR = object : DiffUtil.ItemCallback<UserSummary>() {
            override fun areItemsTheSame(oldItem: UserSummary, newItem: UserSummary): Boolean =
                    oldItem.username == newItem.username

            override fun areContentsTheSame(oldItem: UserSummary, newItem: UserSummary): Boolean =
                    oldItem.username == newItem.username
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchListAdapter.UserViewHolder {
        return UserViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.user_item, parent, false))
    }

    override fun onBindViewHolder(holder: SearchListAdapter.UserViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it, itemClickListener) }
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(userSummary: UserSummary, itemClickListener: (UserSummary) -> Unit) {
            itemView.setOnClickListener { itemClickListener(userSummary) }
            itemView.username.text = userSummary.username
            GlideApp.with(itemView).load(userSummary.avatarUrl).into(itemView.profileImage)
        }
    }
}

