package com.example.testbookchecker.api

import com.example.testbookchecker.models.coversItem
import retrofit2.Call
import retrofit2.create
import retrofit2.http.GET

interface API {

    @GET("covers/")
    fun getRandom(): Call<ArrayList<coversItem>>

    companion object {
        val client by lazy { retrofit.create<API>() }
    }
}

