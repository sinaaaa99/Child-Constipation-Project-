package com.example.constipationproject.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.constipationproject.data.model.ChildInfo
import com.example.constipationproject.data.model.ConsTitleWithText
import com.example.constipationproject.data.model.ConstipationText
import com.example.constipationproject.data.model.ConstipationTitle
import com.example.constipationproject.data.model.Note
import com.example.constipationproject.data.model.ParentInfo
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

    //insert Note
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertNote(note: Note)

    //update Note
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateNote(note: Note)

    //insert Parent Information
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParentInfo(parentInfo: ParentInfo)

    //insert Child Information
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertChildInfo(childInfo: ChildInfo)


    //Read functions.............................................

    //read Title
    @Query("select * from ConstipationTitle where type=:type order by id ASC")
    fun readTitle(type: Int): Flow<List<ConstipationTitle>>

    //read Title with Texts
    @Transaction
    @Query("select * from ConstipationTitle where id=:id  order by id ASC")
    fun readTitleWithText(id: Int): Flow<ConsTitleWithText>

    @Query("select * from Note where type=:noteType order by id")
    fun getNotes(noteType: Int): Flow<List<Note>>

    @Query("select * from Note where id=:noteId")
    fun getSingleNote(noteId: Int): Flow<Note>

    //get Parent Info
    @Query("select * from parentinfo where id=1")
    fun getParentInfo(): Flow<ParentInfo>

    //get Child Info
    @Query("select * from childinfo where id=1")
    fun getChildInfo(): Flow<ChildInfo>


    //Delete functions.........................................
    @Query("delete from Note where id=:noteId")
    suspend fun deleteNote(noteId: Int)


}