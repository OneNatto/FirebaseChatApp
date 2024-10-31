package com.example.firebasechatapp.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firebasechatapp.data.auth.FirebaseAuthService
import com.example.firebasechatapp.ui.auth.AuthViewModel
import com.example.firebasechatapp.ui.chat.UserList

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    UserList(
        modifier = modifier
    )
}