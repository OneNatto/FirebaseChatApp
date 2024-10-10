package com.example.firebasechatapp.ui.auth.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FormWidget(
    modifier: Modifier = Modifier,
    screenLabel: String,
    onClickedFunction:() -> Unit,
) {

    var emailText by remember{ mutableStateOf("") }
    var passwordText by remember{ mutableStateOf("") }


    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(screenLabel)
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
            onClick = onClickedFunction
        ) {
            Text(screenLabel)
        }
    }
}