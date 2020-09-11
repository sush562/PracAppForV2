package com.mine.practiceapplication.repo

import androidx.lifecycle.LiveData
import com.mine.practiceapplication.dao.WordDao
import com.mine.practiceapplication.entity.Word

class WordRepository(private val wordDao: WordDao) {

    // Room executes all queries on a separate thread.
    // Observed LiveData will notify the observer when the data has changed.
    val allWords: LiveData<List<Word>> = wordDao.getWordList()

    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}