package com.example.firebasechatapp.ui.chat

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firebasechatapp.ui.auth.AuthViewModel
import com.example.firebasechatapp.ui.chat.components.UserCard

@Composable
fun UserList(
    modifier: Modifier = Modifier,
    authViewModel: AuthViewModel = viewModel(),
    chatViewModel: ChatViewModel = viewModel()
) {
    val currentUser = chatViewModel.currentUserData.collectAsState()
    //ユーザーリスト
    val userList = chatViewModel.userList.collectAsState().value

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(0.1F))
        Text("${currentUser.value?.userName}さん、こんにちは")
        Spacer(modifier = Modifier.weight(0.1F))
        Text("フレンド")
        Spacer(modifier = Modifier.height(20.dp))
        LazyColumn {
            items(userList) { user ->
                UserCard(
                    user = user,
                    modifier = Modifier.fillMaxWidth(0.9F)
                )
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
        Spacer(modifier = Modifier.weight(1F))
        Button(
            onClick = {authViewModel.signOut()}
        ) {
            Text("ログアウト")
        }
        Spacer(modifier = Modifier.weight(0.2F))
    }
}