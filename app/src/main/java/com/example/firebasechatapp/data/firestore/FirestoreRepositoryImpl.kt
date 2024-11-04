package com.example.firebasechatapp.data.firestore

import com.example.firebasechatapp.data.model.UserModel
import com.example.firebasechatapp.ui.chat.FirestoreRepository
import javax.inject.Inject

class FirestoreRepositoryImpl @Inject constructor(private val firestoreService: FirestoreService) :FirestoreRepository {
    override suspend fun createUser(uid: String, username: String) {
        firestoreService.createUser(uid,username)
    }

    override suspend fun getUserData(uid: String): UserModel {
        return firestoreService.getUserData(uid)
    }

    override suspend fun getOtherUsers(uid: String): List<UserModel> {
        return firestoreService.getOtherUsers(uid)
    }

}