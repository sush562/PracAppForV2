package com.mine.practiceapplication.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "word_table")
data class Word(@PrimaryKey(autoGenerate = true) val id: Int, @NonNull @ColumnInfo val word: String)

data class MockableComments(@SerializedName("comment") val comment: String)