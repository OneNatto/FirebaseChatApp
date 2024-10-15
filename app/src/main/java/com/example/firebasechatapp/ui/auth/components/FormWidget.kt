package com.example.firebasechatapp.ui.auth.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

enum class FormType {
    LOGIN,REGISTER
}

@Composable
fun FormWidget(
    modifier: Modifier = Modifier,
    formType: FormType,
    submitButtonFunction:(String,String) -> Unit,
    switchScreenFunction: () -> Unit
) {

    var emailText by remember{ mutableStateOf("") }
    var passwordText by remember{ mutableStateOf("") }


    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if(formType == FormType.LOGIN) "ログイン画面" else "アカウント登録画面"
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextField(
            value = emailText,
            label = { Text("Eメール") },
            onValueChange = {emailText = it},
            modifier = Modifier.fillMaxWidth(0.85F)
        )
        Spacer(modifier = Modifier.height(10.dp))
        TextField(
            value = passwordText,
            label = { Text("パスワード") },
            onValueChange = {passwordText = it},
            modifier = Modifier.fillMaxWidth(0.85F)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(
            modifier = Modifier.fillMaxWidth(0.6F),
            onClick = {
                submitButtonFunction(emailText,passwordText)
                emailText = ""
                passwordText = ""
            }
        ) {
            Text(
                text = if(formType == FormType.LOGIN) "ログイン" else "登録"
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        TextButton(
            onClick = switchScreenFunction,
        ) {
            Text(
                text = if(formType == FormType.LOGIN) "アカウントを持っていない方" else "すでにアカウントをお持ちの方",
                fontSize = 12.sp,
                color = Color.Blue
            )
        }
    }
}