package com.example.livedata

import android.util.Log
import androidx.lifecycle.LiveData

class MyLiveData: LiveData<String>() {

    fun setChangeLiveData(string: String){
        value = string
    }

    override fun onActive() {
        super.onActive()
        Log.d("NM_Log","function onActive Run")
    }

    override fun onInactive() {
        super.onInactive()
        Log.d("NM_Log","function onInactive Run")
    }
}