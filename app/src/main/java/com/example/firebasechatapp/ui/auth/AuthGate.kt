package com.example.firebasechatapp.ui.auth

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.firebasechatapp.ui.HomeScreen

@Composable
fun AuthGate(
    modifier: Modifier = Modifier,
    viewModel: AuthViewModel = viewModel()
) {
    val isUserLoggedInState = viewModel.isUserLoggedInState.collectAsState().value
    var showLoginScreen by remember { mutableStateOf(true) }

    if(isUserLoggedInState) {
        HomeScreen(modifier = modifier)
    } else {
        if(showLoginScreen) {
            LoginScreen(
                modifier = modifier,
                switchScreenFunction = {
                    showLoginScreen = !showLoginScreen
                }
            )
        } else {
            RegisterScreen(
                modifier = modifier,
                switchScreenFunction = {
                    showLoginScreen = !showLoginScreen
                }
            )
        }
    }
}