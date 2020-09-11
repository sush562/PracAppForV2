package com.mine.practiceapplication.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.mine.practiceapplication.entity.MockableComments
import com.mine.practiceapplication.repo.CommentsRepository

class CommentsViewModel() : ViewModel() {

    val commentList: LiveData<List<MockableComments>>
    val isFetchingComments: LiveData<Boolean>
    private val commentsRepository: CommentsRepository = CommentsRepository()

    init {
        isFetchingComments = commentsRepository.isFetchingComments
        commentList = commentsRepository.commentList
    }

    fun fetchComments(){
        commentsRepository.fetchComments()
    }
}