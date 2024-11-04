package com.example.firebasechatapp.ui.chat

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebasechatapp.data.firestore.FirestoreService
import com.example.firebasechatapp.data.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatViewModel @Inject constructor(private val firestoreRepository: FirestoreRepository): ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    //ログインユーザーデータ
    private val _currentUserData = MutableStateFlow<UserModel?>(null)
    val currentUserData: StateFlow<UserModel?> = _currentUserData.asStateFlow()

    //全ユーザー
    private val _userList = MutableStateFlow<List<UserModel>>(mutableListOf())
    val userList: StateFlow<List<UserModel>> = _userList.asStateFlow()

    init {
        //auth.currentUserを保持するためStateListnerを追加
        auth.addAuthStateListener { auth ->
            val currentUser = auth.currentUser
            if(currentUser != null) {
                viewModelScope.launch {
                    setCurrentUser()
                    setUserList()
                }
            } else {
                _currentUserData.value = null
                _userList.value = emptyList()
            }
        }
    }

    private suspend fun setCurrentUser() {
        _currentUserData.value = firestoreRepository.getUserData(auth.currentUser!!.uid)
    }

    private suspend fun setUserList() {
        _userList.value = firestoreRepository.getOtherUsers(auth.currentUser!!.uid)
    }

}