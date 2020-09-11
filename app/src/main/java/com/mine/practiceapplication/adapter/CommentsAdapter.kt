package com.mine.practiceapplication.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mine.practiceapplication.entity.MockableComments
import com.mine.practiceapplication.entity.Word

class CommentsAdapter(context: Context) : RecyclerView.Adapter<CommentsAdapter.CommentsViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var comments = emptyList<MockableComments>() // Cached copy of words

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        val view = inflater.inflate(android.R.layout.simple_list_item_1, parent, false)
        return CommentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        holder.text1.text = comments[position].comment
    }

    override fun getItemCount(): Int = comments.size

    internal fun setComments(comments: List<MockableComments>) {
        this.comments = comments
        notifyDataSetChanged()
    }

    inner class CommentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val text1: TextView = itemView.findViewById(android.R.id.text1)
    }

}