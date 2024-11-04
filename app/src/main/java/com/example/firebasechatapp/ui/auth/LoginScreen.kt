package com.example.firebasechatapp.ui.auth


import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.firebasechatapp.ui.auth.components.FormType
import com.example.firebasechatapp.ui.auth.components.FormWidget

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = hiltViewModel(),
    switchScreenFunction: () -> Unit
) {
    FormWidget(
        modifier = modifier,
        formType = FormType.LOGIN,
        submitButtonFunction = { _,email, password ->
            viewModel.login(email,password)
        },
        switchScreenFunction = switchScreenFunction

    )
}