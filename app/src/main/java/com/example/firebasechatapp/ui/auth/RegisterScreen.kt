package com.example.firebasechatapp.ui.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.firebasechatapp.ui.auth.components.FormWidget

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier
) {
    FormWidget(
        modifier = modifier,
        screenLabel = "登録",
        onClickedFunction = {}
    )
}