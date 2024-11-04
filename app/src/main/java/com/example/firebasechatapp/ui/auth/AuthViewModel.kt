package com.example.firebasechatapp.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebasechatapp.data.auth.FirebaseAuthService
import com.example.firebasechatapp.data.firestore.FirestoreService
import com.example.firebasechatapp.ui.chat.FirestoreRepository
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: FirebaseAuthRepository,
    private val firestoreRepository: FirestoreRepository
): ViewModel() {
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    //ユーザーがログインしているか
    private val _isUserLoggedInState = MutableStateFlow(false)
    val isUserLoggedInState: StateFlow<Boolean> = _isUserLoggedInState.asStateFlow()


    init {
        _isUserLoggedInState.value = auth.currentUser != null
    }

    fun login(email: String,password: String) {
        viewModelScope.launch {
            val result = authRepository.userLogin(email, password)
            if(result.isSuccess) {
                _isUserLoggedInState.value = true
            } else {
                print(result.exceptionOrNull())
            }
        }
    }

    fun register(
        username: String,
        email: String,
        password: String
    ) {
        viewModelScope.launch {
            val result = authRepository.userRegister(email, password)
            if(result.isSuccess) {
                val currentUser = auth.currentUser
                firestoreRepository.createUser(
                    uid = currentUser!!.uid,
                    username = username
                )
                _isUserLoggedInState.value = true
            } else {
                print(result.exceptionOrNull())
            }
        }
    }

    fun signOut() {
        authRepository.signOut()
        _isUserLoggedInState.value = false
    }
}