package com.mine.practiceapplication.module

import com.mine.practiceapplication.repo.CommentsRepository
import com.mine.practiceapplication.viewmodel.CommentsViewModel
import com.mine.practiceapplication.viewmodel.WordPageViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { WordPageViewModel(get()) }

    viewModel { CommentsViewModel() }
}