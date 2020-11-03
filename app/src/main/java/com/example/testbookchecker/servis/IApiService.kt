package com.example.testbookchecker.servis

import com.example.testbookchecker.models.coversItem
import retrofit2.Response

interface IApiService {
    fun loadCovers(): Response<ArrayList<coversItem>>
}