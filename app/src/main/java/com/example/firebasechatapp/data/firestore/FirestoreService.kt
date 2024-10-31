package com.example.firebasechatapp.data.firestore

import com.example.firebasechatapp.data.model.UserModel
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class FirestoreService {
    private val firestore = Firebase.firestore

    //ユーザー登録
    suspend fun createUser(
        uid: String,
        username: String,
    ) {

        val userData = hashMapOf(
            "name" to username,
            "uid" to uid,
        )

        firestore.collection("users").document(uid)
            .set(userData).addOnSuccessListener {
                println("ユーザー登録成功")
            }.addOnFailureListener { e ->
                println("エラー: $e")
            }.await()
    }

    //現在のユーザーデータ取得
    suspend fun getUserData(uid: String) : UserModel {
        val data = firestore.collection("users").document(uid).get().await()

        val userData = UserModel(
            userName = data["name"].toString(),
            uid = data["uid"].toString()
        )

        return userData
    }

    //ログインユーザー以外の全ユーザー取得
    suspend fun getOtherUsers(uid: String) : List<UserModel> {
        val data = firestore.collection("users").get().await()

        val userList = mutableListOf<UserModel>()

        data.documents.forEach {
            if(it.data!!["uid"].toString() != uid) {
                val userModel = UserModel(
                    userName = it.data!!["name"].toString(),
                    uid = it.data!!["uid"].toString()
                )
                userList.add(userModel)
            }
        }

        return userList
    }
}
