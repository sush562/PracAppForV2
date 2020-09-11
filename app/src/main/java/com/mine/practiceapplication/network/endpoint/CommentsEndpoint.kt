package com.mine.practiceapplication.network.endpoint

import com.mine.practiceapplication.entity.MockableComments
import retrofit2.Call
import retrofit2.http.GET

interface CommentsEndpoint {

    @GET("comments")
    fun getComments(): Call<List<MockableComments>>
}