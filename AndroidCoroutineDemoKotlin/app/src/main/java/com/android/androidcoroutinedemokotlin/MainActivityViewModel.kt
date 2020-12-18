package com.android.androidcoroutinedemokotlin

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.androidcoroutinedemokotlin.network.RetroInstance
import com.android.androidcoroutinedemokotlin.network.RetroService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel: ViewModel() {
    lateinit var imageLiveData: MutableLiveData<Bitmap>


    init {
        imageLiveData = MutableLiveData()
    }


    fun getImageObserver(): MutableLiveData<Bitmap> {
        return imageLiveData
    }

    fun makeApiCall(query: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
            val response  = retroInstance.getImageFromUrl(query)
            val bytes =  response.bytes()
            val bitmap = BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
            imageLiveData.postValue(bitmap)
        }
    }
}