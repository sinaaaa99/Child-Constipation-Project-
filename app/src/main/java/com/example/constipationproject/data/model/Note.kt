package com.example.constipationproject.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    //doctor Type Will Be 1 And Parent Type Will Be 2
    val type:Int,
    val title:String,
    val text:String,
    val importance:Int
)
