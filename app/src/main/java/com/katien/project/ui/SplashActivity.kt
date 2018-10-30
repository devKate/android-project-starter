package com.katien.project.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import org.koin.android.viewmodel.ext.android.viewModel

class SplashActivity : AppCompatActivity() {

    private val splashViewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        splashViewModel.isAuthed.observe(this, Observer {

            if (it == true) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }

        })
        splashViewModel.checkAuth()
    }
}
