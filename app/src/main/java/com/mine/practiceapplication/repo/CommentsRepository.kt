package com.mine.practiceapplication.repo

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mine.practiceapplication.entity.MockableComments
import com.mine.practiceapplication.network.RetroFitClass
import com.mine.practiceapplication.network.endpoint.CommentsEndpoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CommentsRepository {

    var commentList: MutableLiveData<List<MockableComments>> = MutableLiveData(emptyList())
    var isFetchingComments: MutableLiveData<Boolean> = MutableLiveData(false)

    fun fetchComments() {
        isFetchingComments.value = true
        val apiService = RetroFitClass.retrofit.create(CommentsEndpoint::class.java)
        val call: Call<List<MockableComments>> = apiService.getComments()
        call.enqueue(object : Callback<List<MockableComments>>{
            override fun onResponse(
                call: Call<List<MockableComments>>,
                response: Response<List<MockableComments>>
            ) {
                isFetchingComments.value = false
                commentList.value = response.body() ?: emptyList()
            }

            override fun onFailure(call: Call<List<MockableComments>>, t: Throwable) {
                isFetchingComments.value = false
                Log.e(CommentsRepository::class.simpleName, t.message, t)
            }

        })
    }
}