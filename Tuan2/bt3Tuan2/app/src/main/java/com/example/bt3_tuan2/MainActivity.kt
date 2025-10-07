package com.example.bt3_tuan2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.bt3_tuan2.ui.theme.Bt3Tuan2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bt3Tuan2Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                        Screen(modifier = Modifier.padding(innerPadding).fillMaxSize().padding(horizontal = 24.dp, vertical = 16.dp))
                }
            }
        }
    }
}

@Composable
fun Screen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        // Toàn bộ form nằm giữa màn hình
        Column(
            modifier = Modifier
                .align(Alignment.Center)   // ⬅️ Căn giữa cả dọc & ngang
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ScreenTenTuoi()
        }
    }
}

@Composable
fun ScreenTenTuoi(){
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var res   by remember { mutableStateOf<String?>(null) }

    Column (
        modifier = Modifier.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("Thực hành 01", fontSize = 20.sp)
        Surface (
            shape = RoundedCornerShape(12.dp),
            tonalElevation = 2.dp,
            color = MaterialTheme.colorScheme.surfaceVariant,
            modifier = Modifier.fillMaxWidth(),
        ){
            Column (
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ){
                // ho va ten
                Row (
                    verticalAlignment = Alignment.CenterVertically
                )
                {
                    Spacer(modifier = Modifier.height(16.dp))
                    // name
                    Text(
                        "Họ và tên",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.width(100.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    TextField(
                        value = name,
                        onValueChange = {
                            name = it
                        },
                        singleLine = true,
                        modifier = Modifier.width(200.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White,
                            errorContainerColor = Color.White,
                            // Ẩn gạch chân cho giống ô trắng phẳng
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent,
                            // Màu chữ & con trỏ
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black,
                            cursorColor = MaterialTheme.colorScheme.primary,
                        )

                    )
                }
                Spacer(modifier = Modifier.height(12.dp))
                // tuoi
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        "Tuổi",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.width(100.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    TextField(
                        value = age,
                        onValueChange = {age = it},
                        singleLine = true,
                        modifier = Modifier.width(200.dp),
                        colors = TextFieldDefaults.colors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White,
                            errorContainerColor = Color.White,
                            // Ẩn gạch chân cho giống ô trắng phẳng
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent,
                            disabledIndicatorColor = Color.Transparent,
                            errorIndicatorColor = Color.Transparent,
                            // Màu chữ & con trỏ
                            focusedTextColor = Color.Black,
                            unfocusedTextColor = Color.Black,
                            cursorColor = MaterialTheme.colorScheme.primary,
                        )
                    )
                }
            }
        }
        res?.let{
            Spacer(modifier = Modifier.height(16.dp))
            Text(it, fontSize = 16.sp)
        }
        Spacer(modifier = Modifier.height(12.dp))
        Button(
            onClick = {
                val a = age.trim().toIntOrNull()
                res = when {
                    a == null -> "Vui lòng nhập tuổi hợp lệ"
                    a < 0 -> "Tuổi không được bé hơn 0"
                    a > 65 -> "Người già"
                    a > 6 -> "Người lớn"
                    a > 2 -> "trẻ em"
                    else -> "em bé"
                }
            }
        ) { Text("Kiểm tra") }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Bt3Tuan2Theme {
        Screen()
    }
}