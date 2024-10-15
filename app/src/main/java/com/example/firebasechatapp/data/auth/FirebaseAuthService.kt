package com.example.firebasechatapp.data.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import kotlinx.coroutines.tasks.await

class FirebaseAuthService {
    val auth: FirebaseAuth = FirebaseAuth.getInstance()

    suspend fun userLogin(
        email: String,
        password: String
    ): Result<Unit> {
        return try {
            auth.signInWithEmailAndPassword(email,password).await()
            Result.success(Unit)
        } catch(e:FirebaseAuthException) {
            print(e.message)
            Result.failure(e)
        }
    }

    suspend fun userRegister(
        email:String,
        password:String
    ): Result<Unit> {
        return try {
            auth.createUserWithEmailAndPassword(email,password).await()
            Result.success(Unit)
        } catch(e:FirebaseAuthException) {
            print(e.message)
            Result.failure(e)

        }
    }

    fun signOut() {
        auth.signOut()
    }
}