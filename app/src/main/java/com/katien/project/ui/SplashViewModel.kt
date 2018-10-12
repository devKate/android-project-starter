package com.katien.project.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.experimental.*
import javax.inject.Inject

class SplashViewModel @Inject constructor() : ViewModel() {
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
