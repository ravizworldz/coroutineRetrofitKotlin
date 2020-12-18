package com.android.androidcoroutinedemokotlin.network

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroService {

    @GET("33503405")
    suspend fun getImageFromUrl(@Query("v") query: String): ResponseBody
}