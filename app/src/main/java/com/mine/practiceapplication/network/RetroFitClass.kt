package com.mine.practiceapplication.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroFitClass {

    companion object {

        val retrofit: Retrofit = Retrofit.Builder().baseUrl("https://demo6406318.mockable.io/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }


}