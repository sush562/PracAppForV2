package com.mine.practiceapplication.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mine.practiceapplication.entity.Word

@Dao
interface WordDao {

    @Insert
    fun insert(word: Word)

    @Query("DELETE from word_table")
    fun deleteAll()

    @Query("SELECT * FROM word_table")
    fun getWordList(): LiveData<List<Word>>
}