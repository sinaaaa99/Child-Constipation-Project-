package com.example.constipationproject.data.repository

import com.example.constipationproject.data.db.ConstipationDao
import com.example.constipationproject.data.model.ConsTitleWithText
import com.example.constipationproject.data.model.ConstipationText
import com.example.constipationproject.data.model.ConstipationTitle
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


    //get functions............................................

    //get Title
    fun getTitles(type: Int): Flow<List<ConstipationTitle>> = constipationDao.readTitle(type)

    //get Titles with Texts
    fun getTitleWithText(id: Int): Flow<ConsTitleWithText> =
        constipationDao.readTitleWithText(id)

}