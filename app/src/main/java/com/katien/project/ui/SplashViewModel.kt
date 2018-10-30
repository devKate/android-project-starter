package com.katien.project.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.experimental.CoroutineScope
import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.Job
import kotlinx.coroutines.experimental.launch

class SplashViewModel : ViewModel() {
    val isAuthed = MutableLiveData<Boolean>()

    val job = Job()
    val uiScope = CoroutineScope(Dispatchers.Main + job)

    fun checkAuth() {
        uiScope.launch {
            //            delay(1_000)
            isAuthed.value = true
        }
    }

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}
