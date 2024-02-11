package com.example.constipationproject.data.model

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    indices = [
        Index("id")
    ]
)
data class ConstipationTitle(
    @PrimaryKey
    val id: Int,
    val title: String,
    val type: Int
)
