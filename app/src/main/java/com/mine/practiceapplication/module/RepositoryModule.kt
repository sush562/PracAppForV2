package com.mine.practiceapplication.module

import android.app.Application
import com.mine.practiceapplication.dao.WordDao
import com.mine.practiceapplication.db.WordRoomDatabase
import com.mine.practiceapplication.repo.WordRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val repoModule = module {
    factory { getWordDao(androidApplication()) }
    single { getWordRepository(get()) }
}

private fun getWordRepository(wordDao: WordDao): WordRepository {
    return WordRepository(wordDao)
}

private fun getWordDao(application: Application): WordDao {
    return WordRoomDatabase.getDatabase(application).wordDao()
}