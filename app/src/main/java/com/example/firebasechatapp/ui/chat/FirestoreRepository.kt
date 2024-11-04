package com.example.firebasechatapp.ui.chat

import com.example.firebasechatapp.data.firestore.FirestoreService
import com.example.firebasechatapp.data.model.UserModel
import javax.inject.Inject

interface FirestoreRepository {
    suspend fun createUser(uid :String,username: String)

    suspend fun getUserData(uid: String) :UserModel

    suspend fun getOtherUsers(uid: String): List<UserModel>
}