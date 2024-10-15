package com.example.firebasechatapp.ui.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firebasechatapp.data.auth.FirebaseAuthService
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class AuthViewModel(): ViewModel() {
    val authService = FirebaseAuthService()
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _isUserLoggedInState = MutableStateFlow(false)
    val isUserLoggedInState: StateFlow<Boolean> = _isUserLoggedInState.asStateFlow()

    init {
        _isUserLoggedInState.value = auth.currentUser != null
    }

    fun login(email: String,password: String) {
        viewModelScope.launch {
            val result = authService.userLogin(email, password)
            if(result.isSuccess) {
                _isUserLoggedInState.value = true
            } else {
                print(result.exceptionOrNull())
            }
        }
    }

    fun register(email: String,password: String) {
        viewModelScope.launch {
            val result = authService.userRegister(email, password)
            if(result.isSuccess) {
                _isUserLoggedInState.value = true
            } else {
                print(result.exceptionOrNull())
            }
        }
    }

    fun signOut() {
        authService.signOut()
        _isUserLoggedInState.value = false
    }
}