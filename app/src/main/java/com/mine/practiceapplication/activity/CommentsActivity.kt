package com.mine.practiceapplication.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mine.practiceapplication.R
import com.mine.practiceapplication.fragment.CommentsFragment
import com.mine.practiceapplication.viewmodel.BaseViewModel

class CommentsActivity : BaseActivity<BaseViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comments_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CommentsFragment.newInstance())
                .commitNow()
        }
    }
}