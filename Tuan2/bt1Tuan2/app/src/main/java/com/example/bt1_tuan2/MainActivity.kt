package com.example.bt1_tuan2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bt1_tuan2.ui.theme.Bt1_Tuan2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Bt1_Tuan2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        Screen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@Composable
fun Screen(modifier: Modifier = Modifier){
    var number by remember { mutableStateOf("") }
    var lnumber by remember { mutableStateOf(listOf<Int>()) }
    var error by remember { mutableStateOf<String?>(null)  }
    Column(
        modifier = modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ){
        Spacer(Modifier.weight(1f))
        Text("Thực hành 02", fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Row (Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically) {
            OutlinedTextField(
                value = number,
                modifier = Modifier.weight(1f),
                onValueChange = {number = it},
                singleLine = true,
                placeholder = {Text("Nhập vào số lượng")},
                shape = RoundedCornerShape(24.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.width(6.dp))
            Button(
                onClick = {
                    val n = number.trim().toIntOrNull()
                    if(n != null && n > 0){
                        lnumber = (1..n).toList()
                        error = null
                    }
                    else{
                        lnumber = emptyList()
                        error = "Dữ liệu bạn nhập không hợp lệ"
                    }
                }
            ) { Text("Tạo") }
        }
        error?.let{
            Spacer(modifier = Modifier.height(6.dp))
            Text(text = it, color = MaterialTheme.colorScheme.error)
        }
        Spacer(modifier = Modifier.height(12.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        )
        {
            items (lnumber){ i->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(48.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .background(Color(0xFFE24B3A)) // đỏ
                        .padding(horizontal = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = i.toString(),
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.White
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Bt1_Tuan2Theme {
        Screen()
    }
}