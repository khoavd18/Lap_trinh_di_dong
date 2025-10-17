package com.example.tuan3

import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tuan3.ui.theme.Tuan3Theme

@Composable
fun Block(color: Color) {
    Box(
        modifier = Modifier
            .size(width = 96.dp, height = 56.dp)      // chỉnh tuỳ ý
            .clip(RoundedCornerShape(16.dp))
            .background(color)
    )
}
@Composable
fun ThreeRow(){
    Block(color = Color.Blue)
    Spacer(modifier = Modifier.width(12.dp))
    Block(color = Color.Red)
    Spacer(modifier = Modifier.width(12.dp))
    Block(color = Color.Green)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenRow(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Row") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { inner ->
        Column(
            modifier = Modifier.fillMaxSize().padding(inner),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.padding(16.dp).clip(RoundedCornerShape(16.dp))

            ) {
                ThreeRow()
            }
            Row(
                modifier = Modifier.padding(16.dp).clip(RoundedCornerShape(16.dp))
            ) {
                ThreeRow()
            }
            Row(
                modifier = Modifier.padding(16.dp).clip(RoundedCornerShape(16.dp))
            ) {
                ThreeRow()
            }
            Row(
                modifier = Modifier.padding(16.dp).clip(RoundedCornerShape(16.dp))
            ) {
                ThreeRow()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview5() {
    Tuan3Theme {
        ScreenRow(onBack = {})
    }
}