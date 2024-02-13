package com.example.constipationproject.data.repository

import com.example.constipationproject.data.db.ConstipationDao
import com.example.constipationproject.data.model.ChildInfo
import com.example.constipationproject.data.model.ConsTitleWithText
import com.example.constipationproject.data.model.ConstipationText
import com.example.constipationproject.data.model.ConstipationTitle
import com.example.constipationproject.data.model.Note
import com.example.constipationproject.data.model.ParentInfo
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class Repository @Inject constructor(private val constipationDao: ConstipationDao) {


    //insert Functions........................................

    //insert Title
    suspend fun insertTitle(constipationTitle: ConstipationTitle) =
        constipationDao.insertTitle(constipationTitle)

    //insert Text
    suspend fun insertText(constipationText: ConstipationText) =
        constipationDao.insertText(constipationText)

    //insert Note
    suspend fun insertNote(note: Note) = constipationDao.insertNote(note)

    //update Note
    suspend fun updateNote(note: Note) = constipationDao.updateNote(note)


    //insert Parent Info
    suspend fun insertParentInfo(parentInfo: ParentInfo) =
        constipationDao.insertParentInfo(parentInfo)

    //insert Child Info
    suspend fun insertChildInfo(childInfo: ChildInfo) = constipationDao.insertChildInfo(childInfo)


    //get functions............................................

    //get Title
    fun getTitles(type: Int): Flow<List<ConstipationTitle>> = constipationDao.readTitle(type)

    //get Titles with Texts
    fun getTitleWithText(id: Int): Flow<ConsTitleWithText> =
        constipationDao.readTitleWithText(id)

    fun getNotes(noteType: Int): Flow<List<Note>> =
        constipationDao.getNotes(noteType)

    fun getSingleNote(noteId: Int): Flow<Note> =
        constipationDao.getSingleNote(noteId)

    //get parent Info
    val getParentInfo: Flow<ParentInfo> = constipationDao.getParentInfo()

    //get parent Info
    val getChildInfo: Flow<ChildInfo> = constipationDao.getChildInfo()


    //delete functions......................................
    suspend fun deleteNote(noteId: Int) = constipationDao.deleteNote(noteId)

}