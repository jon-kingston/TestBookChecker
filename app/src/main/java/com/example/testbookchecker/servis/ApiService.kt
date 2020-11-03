package com.example.testbookchecker.servis

import com.example.testbookchecker.api.API

object ApiService: IApiService {
    override fun loadCovers() =
        API.client.getRandom().execute()
}