package com.example.firebasechatapp.ui.auth

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.firebasechatapp.ui.auth.components.FormType
import com.example.firebasechatapp.ui.auth.components.FormWidget
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = viewModel(),
    switchScreenFunction: () -> Unit
) {
    FormWidget(
        modifier = modifier,
        formType = FormType.REGISTER,
        submitButtonFunction = { username, email, password ->
            viewModel.register(username ?: "",email,password)
        },
        switchScreenFunction = switchScreenFunction
    )
}