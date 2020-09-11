package com.mine.practiceapplication.viewmodel

import androidx.lifecycle.LiveData
import com.mine.practiceapplication.entity.MockableComments
import com.mine.practiceapplication.repo.CommentsRepository

class CommentsViewModel() : BaseViewModel() {

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