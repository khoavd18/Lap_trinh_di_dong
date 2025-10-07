package com.example.bt2_tuan2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MaterialTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                ){ innerPadding ->
                    Screen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun Screen(modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(24.dp)) {
        Screen_email()
    }
}

@Composable
fun Screen_email(){
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf<String?>(null) }
    var isCorrect by remember { mutableStateOf(false) }
    Column (
        modifier = Modifier.fillMaxSize().padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Thực hành 02", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = email,
            label = {
                Text("Email")
            },
            onValueChange = {
                email = it
                message = null
                isCorrect = false
            },
            singleLine = true,
            modifier = Modifier.fillMaxWidth()
        )
        message?.let{
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = it,
                color = if(isCorrect) Color(0xFF2E7D32) else Color(0xFFD32F2F)
            )
        }
        Button(
            onClick = {
                val e = email.trim()
                message = when{
                    e.isEmpty() -> {
                        isCorrect = false
                        "Email không hợp lệ"
                    }
                    !e.contains("@") -> {
                        isCorrect = false
                        "Email không đúng định dạng"
                    }
                    else -> {
                        isCorrect = true
                        "Bạn đã nhập email hợp lệ"
                    }
                }
            }
        ) { Text("Kiểm tra") }

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MaterialTheme {
        Screen()
    }
}