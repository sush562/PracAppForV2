package com.mine.practiceapplication.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.mine.practiceapplication.R
import com.mine.practiceapplication.adapter.CommentsAdapter
import com.mine.practiceapplication.viewmodel.CommentsViewModel
import org.koin.android.ext.android.inject

class CommentsFragment : Fragment() {

    private lateinit var commentsRecyclerView: RecyclerView
    private lateinit var fetchProgressBar: ProgressBar

    companion object {
        fun newInstance() = CommentsFragment()
    }

    private val commentViewModel: CommentsViewModel by inject()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.comments_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        commentsRecyclerView = view.findViewById(R.id.comments_rv)
        fetchProgressBar = view.findViewById(R.id.comments_progressbar)

        setListeners()

        commentViewModel.fetchComments()
    }

    private fun setListeners() {
        commentViewModel.commentList.observe(viewLifecycleOwner, {
            it?.let {
                if(commentsRecyclerView.adapter == null){
                    commentsRecyclerView.adapter = CommentsAdapter(activity as Context)
                }
                (commentsRecyclerView.adapter as CommentsAdapter).setComments(it)
            }
        })
        commentViewModel.isFetchingComments.observe(viewLifecycleOwner, { isFetching ->
            if (isFetching) fetchProgressBar.visibility =
                View.VISIBLE else fetchProgressBar.visibility = View.GONE
        })
    }

}