package com.example.firebasechatapp.ui.auth

interface FirebaseAuthRepository {
    suspend fun userLogin(email: String,password: String): Result<Unit>

    suspend fun userRegister(email: String,password: String): Result<Unit>

    fun signOut()
}