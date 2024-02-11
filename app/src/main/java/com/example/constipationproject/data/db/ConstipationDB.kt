package com.example.constipationproject.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.constipationproject.data.MenuClass
import com.example.constipationproject.data.model.ConstipationText
import com.example.constipationproject.data.model.ConstipationTitle
import com.example.constipationproject.data.model.TPConstipation

@Database(
    entities = [ConstipationTitle::class, ConstipationText::class],
    version = 1,
    exportSchema = false
)
abstract class ConstipationDB : RoomDatabase() {

    abstract fun constipationDao(): ConstipationDao
}