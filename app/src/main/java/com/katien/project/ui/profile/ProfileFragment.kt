package com.katien.project.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.katien.project.GlideApp
import com.katien.project.R
import com.katien.project.remote.util.ServerError
import com.katien.project.ui.util.makeToast
import kotlinx.android.synthetic.main.profile_fragment.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.ext.android.viewModel

class ProfileFragment : Fragment() {


    val profileViewModel: ProfileViewModel by viewModel()

    val uiScope = CoroutineScope(Dispatchers.Main)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.profile_fragment, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        uiScope.launch {
            try {
                val profile = profileViewModel.fetchProfile(ProfileFragmentArgs.fromBundle(arguments!!).username)
                GlideApp.with(this@ProfileFragment)
                        .load(profile.avatarUrl)
                        .placeholder(R.drawable.background_splash)
                        .into(profilePicture)

                username.text = profile.username
                fullname.text = profile.fullName
                location.text = profile.location
                company.text = profile.company
            } catch (e: ServerError) {
                context?.makeToast("Server error")
                findNavController().popBackStack(R.id.searchFragment, true)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        uiScope.coroutineContext.cancel()
    }
}
