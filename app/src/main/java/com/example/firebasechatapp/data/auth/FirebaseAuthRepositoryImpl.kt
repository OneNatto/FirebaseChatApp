package com.example.firebasechatapp.data.auth

import com.example.firebasechatapp.ui.auth.FirebaseAuthRepository
import javax.inject.Inject

class FirebaseAuthRepositoryImpl @Inject constructor (private val authService: FirebaseAuthService): FirebaseAuthRepository {
    override suspend fun userLogin(email: String, password: String): Result<Unit> {
        return authService.userLogin(email,password)
    }

    override suspend fun userRegister(email: String, password: String): Result<Unit> {
        return authService.userRegister(email,password)
    }

    override fun signOut() {
        authService.signOut()
    }
}