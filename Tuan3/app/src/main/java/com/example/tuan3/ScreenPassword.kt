package com.example.tuan3
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import com.example.tuan3.ui.theme.Tuan3Theme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenPassword(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("TextField", color = Color.Blue) },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { inner ->
        var tendangnhap by remember { mutableStateOf("") }
        var matkhau by remember { mutableStateOf("") }
        Column(
            modifier = Modifier
                .padding(inner)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = tendangnhap,
                onValueChange = { tendangnhap = it },
                label = { Text("Tên đăng nhập") },
                shape = RoundedCornerShape(24.dp)
            )

            Spacer(modifier = Modifier.padding(8.dp))

            OutlinedTextField(
                value = matkhau,
                onValueChange = { matkhau = it },
                label = { Text("Mật khẩu") },
                shape = RoundedCornerShape(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview8() {
    Tuan3Theme {
        ScreenPassword(onBack = {})
    }
}