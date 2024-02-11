package com.example.constipationproject.di

import android.content.Context
import androidx.room.Room
import com.example.constipationproject.data.db.ConstipationDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataBaseModule {

    @Singleton
    @Provides
    fun dataBaseProvider(@ApplicationContext context: Context) =
        Room.databaseBuilder(
            context,
            ConstipationDB::class.java,
            "ConstipationDB"
        ).build()

    @Singleton
    @Provides
    fun daoProvider(database: ConstipationDB) = database.constipationDao()


}