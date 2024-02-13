package com.example.constipationproject.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ParentInfo(
    @PrimaryKey
    val id: Int,
    val sex: Int,
    val name: String,
    val age: String,
    val studyLevel: String,
    val job: String,
    val married: String,
    val income: String,
    val location: String,
    val phone: String,
    val healthStatus: String
)
