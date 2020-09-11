package com.mine.practiceapplication.activity

import androidx.appcompat.app.AppCompatActivity
import com.mine.practiceapplication.viewmodel.BaseViewModel

open class BaseActivity<VM: BaseViewModel>: AppCompatActivity() {

    lateinit var viewModel: VM
}