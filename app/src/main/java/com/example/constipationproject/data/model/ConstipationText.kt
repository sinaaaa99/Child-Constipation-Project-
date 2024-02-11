package com.example.constipationproject.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [
        ForeignKey(
            entity = ConstipationTitle::class,
            parentColumns = ["id"],
            childColumns = ["parentId"],
            onDelete = ForeignKey.CASCADE
        )
    ], indices = [Index("parentId")]
)
data class ConstipationText(
    @PrimaryKey
    val id: Int,
    val title: String,
    val text: String,
    val parentId: Int
)
