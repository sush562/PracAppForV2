package com.mine.practiceapplication.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mine.practiceapplication.db.WordRoomDatabase
import com.mine.practiceapplication.entity.Word
import com.mine.practiceapplication.repo.WordRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class WordPageViewModel(application: Application) : BaseViewModel() {

    private val repository: WordRepository
    val allWords: LiveData<List<Word>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords

    }

    /**
     * Launching a new coroutine to insert the data in a non-blocking way
     */
    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }

    suspend fun asyncTest(){
        val i = viewModelScope.async {
            delay(4000)
            Log.e("ABC", "ABC1")
        }
        Log.e("ABC", "ABC2")
        i.await()
        Log.e("ABC", "ABC3")
    }
}