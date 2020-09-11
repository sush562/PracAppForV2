package com.mine.practiceapplication.activity

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mine.practiceapplication.R
import com.mine.practiceapplication.adapter.WordAdapter
import com.mine.practiceapplication.databinding.ActivityMainBinding
import com.mine.practiceapplication.entity.Word
import com.mine.practiceapplication.viewmodel.WordPageViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.getViewModel
import org.koin.core.context.GlobalContext

class MainActivity : BaseActivity<WordPageViewModel>() {

    //private val wordViewModel: WordPageViewModel by inject()
    private lateinit var binding: ActivityMainBinding
    private lateinit var wordRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = getViewModel()

        GlobalScope.launch { viewModel.asyncTest() }

        wordRecyclerView = binding.homeWordRv
        wordRecyclerView.layoutManager = LinearLayoutManager(this)


        viewModel.allWords.observe(this, Observer { words ->
            words?.let {
                if (wordRecyclerView.adapter == null) {
                    wordRecyclerView.adapter = WordAdapter(this)
                }
                (wordRecyclerView.adapter as WordAdapter).setWords(it)
            }
        })

        binding.homeAddWordButton.setOnClickListener {
            if (!TextUtils.isEmpty(binding.homeAddWordEt.text)) {
                viewModel.insert(Word(0, binding.homeAddWordEt.text.toString()))
                binding.homeAddWordEt.text.clear()
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.game_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        return when (item.itemId) {
            R.id.comment_page -> {
                startActivity(Intent(this, CommentsActivity::class.java))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}