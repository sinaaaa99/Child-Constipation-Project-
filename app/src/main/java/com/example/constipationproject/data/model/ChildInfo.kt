package com.example.constipationproject.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ChildInfo(
    @PrimaryKey
    val id: Int,
    val sex: Int,
    val name: String,
    val age: String,
    val weight: String,
    val tall: String,
    val medicine: String,
    val illness: String
)
