package com.katien.project.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*

class SplashViewModel : ViewModel() {
    val isAuthed = MutableLiveData<Boolean>()

    val uiScope = CoroutineScope(Dispatchers.Main + Job())

    fun checkAuth() =
        uiScope.launch {
            isAuthed.value = true
        }


    override fun onCleared() {
        super.onCleared()
        uiScope.coroutineContext.cancel()
    }
}
