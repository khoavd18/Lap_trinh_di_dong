package com.example.tuan3

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tuan3.ui.theme.Tuan3Theme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScreenText(onBack: () -> Unit) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Text Detail") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { inner ->

        val txt = buildAnnotatedString {
            append("The ")

            withStyle(SpanStyle(textDecoration = TextDecoration.LineThrough)) {
                append("quick")
            }
            append(" ")

            withStyle(SpanStyle(color = Color(0xFF8B5E3C), fontWeight = FontWeight.Bold)) {
                append("B")
            }
            withStyle(SpanStyle(color = Color(0xFF8B5E3C))) {
                append("rown")
            }

            append("\nfox ")

            // Cách giống ảnh: chèn khoảng trắng thật giữa các ký tự
            append(listOf('j','u','m','p','s').joinToString(" "))
            append(" ")

            withStyle(SpanStyle(fontWeight = FontWeight.Medium)) {
                append("over")
            }

            append("\n")
            withStyle(SpanStyle(textDecoration = TextDecoration.Underline)) { // nếu muốn gạch CHÂN "the"
                append("the")
            }
            append(" ")
            withStyle(SpanStyle(fontStyle = FontStyle.Italic)) {
                append("lazy")
            }
            append(" dog.")
        }

        Box(
            modifier = Modifier
                .padding(inner)          // QUAN TRỌNG: tránh nội dung bị app bar che
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = txt,
                textAlign = TextAlign.Start,
                lineHeight = 40.sp,
                fontSize = 40.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Previewg3() {
    Tuan3Theme {
        ScreenText(onBack = {})
    }
}
