package com.example.constipationproject.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.constipationproject.data.model.ConsTitleWithText
import com.example.constipationproject.data.model.ConstipationText
import com.example.constipationproject.data.model.ConstipationTitle
import kotlinx.coroutines.flow.Flow

@Dao
interface ConstipationDao {

    //insert functions........................................

    //insert Title
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTitle(constipationTitle: ConstipationTitle)

    //insert Text
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertText(constipationText: ConstipationText)


    //Read functions.............................................

    //read Title
    @Query("select * from ConstipationTitle where type=:type order by id ASC")
    fun readTitle(type:Int): Flow<List<ConstipationTitle>>

    //read Title with Texts
    @Transaction
    @Query("select * from ConstipationTitle where id=:id  order by id ASC")
    fun readTitleWithText(id:Int):Flow<ConsTitleWithText>

}