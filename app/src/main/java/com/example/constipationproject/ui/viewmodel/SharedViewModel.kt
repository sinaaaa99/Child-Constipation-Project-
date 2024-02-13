package com.example.constipationproject.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.constipationproject.data.MenuClass
import com.example.constipationproject.data.model.ChildInfo
import com.example.constipationproject.data.model.ConsTitleWithText
import com.example.constipationproject.data.model.ConstipationTitle
import com.example.constipationproject.data.model.Note
import com.example.constipationproject.data.model.ParentInfo
import com.example.constipationproject.data.prepopulate.PrepopulateConsText
import com.example.constipationproject.data.prepopulate.PrepopulateConsTitle
import com.example.constipationproject.data.prepopulate.PrepopulateMenuItem
import com.example.constipationproject.data.repository.Repository
import com.example.constipationproject.util.RequestState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(private val repository: Repository) : ViewModel() {


    //variables.................

    //for get Title
    val educationType = MutableStateFlow(1)

    //for get Title With Text
    val educationId = MutableStateFlow(1)
    val shownPointIndex = MutableStateFlow(0)

    //for find Type of Note
    var noteType = MutableStateFlow(0)
    var noteId = MutableStateFlow(0)

    //insert functions.................................................

    //insert Main Menu Items
    private val _menuItems = MutableStateFlow<RequestState<List<MenuClass>>>(RequestState.Idle)
    val menuItems: StateFlow<RequestState<List<MenuClass>>> = _menuItems

    private fun prepopulateMenuItems() {
        _menuItems.value = RequestState.Loading

        viewModelScope.launch(Dispatchers.IO) {

            val listOfData = PrepopulateMenuItem.listOfMenuItem()
            _menuItems.value = RequestState.Success(listOfData)

        }
    }

    //insert Titles
    private fun insertTitle() {

        viewModelScope.launch(Dispatchers.IO) {

            for (title in PrepopulateConsTitle.listOfTitle) {

                repository.insertTitle(title)

            }
        }
    }

    //insert Text
    private fun insertText() {

        viewModelScope.launch(Dispatchers.IO) {

            for (text in PrepopulateConsText.listOfText) {

                repository.insertText(text)
            }
        }
    }

    //insert Note
    fun insertNote(note: Note) {

        viewModelScope.launch(Dispatchers.IO) {

            repository.insertNote(note)

        }
    }

    //update Note
    fun updateNote(note: Note) {

        viewModelScope.launch(Dispatchers.IO) {

            repository.updateNote(note)

        }
    }

    //insert Parent Info
    fun insertParentInfo(parentInfo: ParentInfo) {

        viewModelScope.launch(Dispatchers.IO) {

            repository.insertParentInfo(parentInfo)
        }
    }


    //insert Child Info
    fun insertChildInfo(childInfo: ChildInfo) {

        viewModelScope.launch(Dispatchers.IO) {

            repository.insertChildInfo(childInfo)
        }
    }


    //get functions..............................

    //get Title
    private val _titles = MutableStateFlow<RequestState<List<ConstipationTitle>>>(RequestState.Idle)
    val titles: StateFlow<RequestState<List<ConstipationTitle>>> = _titles

    fun getTitles() {
        _titles.value = RequestState.Loading

        try {

            viewModelScope.launch(Dispatchers.IO) {

                repository.getTitles(educationType.value).collect { constipationTitleByType ->

                    _titles.value = RequestState.Success(constipationTitleByType)

                }
            }
        } catch (_: Exception) {
        }
    }

    //get Title with Text
    private val _titleAndText =
        MutableStateFlow<RequestState<ConsTitleWithText>>(RequestState.Idle)
    val titleAndText: StateFlow<RequestState<ConsTitleWithText>> = _titleAndText

    fun getTitleWithText() {

        _titleAndText.value = RequestState.Loading

        try {
            viewModelScope.launch(Dispatchers.IO) {

                repository.getTitleWithText(educationId.value).collect { titleWithText ->

                    _titleAndText.value = RequestState.Success(titleWithText)

                }
            }

        } catch (_: Exception) {
        }
    }

    //get Notes
    private val _notes = MutableStateFlow<RequestState<List<Note>>>(RequestState.Idle)
    val notes: StateFlow<RequestState<List<Note>>> = _notes
    fun getNotes() {
        _notes.value = RequestState.Loading

        try {

            viewModelScope.launch(Dispatchers.IO) {
                repository.getNotes(noteType.value).collect { noteByType ->

                    _notes.value = RequestState.Success(noteByType)
                }


            }
        } catch (_: Exception) {
        }
    }

    //get Single Note
    private val _oneNote = MutableStateFlow<RequestState<Note>>(RequestState.Idle)
    val oneNote: StateFlow<RequestState<Note>> = _oneNote
    fun getSingleNote() {
        _oneNote.value = RequestState.Loading

        try {

            viewModelScope.launch(Dispatchers.IO) {
                repository.getSingleNote(noteId.value).collect { note ->
                    _oneNote.value = RequestState.Success(note)

                }

            }
        } catch (_: Exception) {
        }
    }


    //get parent Info
    private val _pInfo = MutableStateFlow<RequestState<ParentInfo>>(RequestState.Idle)
    val pInfo: StateFlow<RequestState<ParentInfo>> = _pInfo

    fun getParentInfo() {
        _pInfo.value = RequestState.Loading
        viewModelScope.launch(Dispatchers.IO) {

            repository.getParentInfo.collect { parentInfo ->
                _pInfo.value = RequestState.Success(parentInfo)
            }
        }
    }


    //get child Info
    private val _cInfo = MutableStateFlow<RequestState<ChildInfo>>(RequestState.Idle)
    val cInfo: StateFlow<RequestState<ChildInfo>> = _cInfo

    fun getChildInfo() {
        _cInfo.value = RequestState.Loading
        viewModelScope.launch(Dispatchers.IO) {

            repository.getChildInfo.collect { childInfo ->
                _cInfo.value = RequestState.Success(childInfo)
            }
        }
    }

    //delete Note............
    fun deleteNote() {

        viewModelScope.launch(Dispatchers.IO) {

            repository.deleteNote(noteId.value)
        }
    }

    //increase and decrease Shown Point

    //increase
    fun increaseShownPoint() {


        shownPointIndex.value += 1
    }

    //decrease
    fun decreaseShownPoint() {

        if (shownPointIndex.value == 0) {

        } else {
            shownPointIndex.value -= 1
        }
    }

    init {
        prepopulateMenuItems()
        insertTitle()
        insertText()
    }
}