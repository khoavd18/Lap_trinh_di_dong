package com.example.tuan3

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tuan3.ui.theme.Tuan3Theme
@Composable
fun ItemCard(title: String, subtitle: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(12.dp).clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f))

    ) {
        Column(Modifier.padding(16.dp)) {
            Text(title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
            Text(subtitle, style = MaterialTheme.typography.bodySmall)
        }
    }
}
@Composable
fun ScreenUI(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize().statusBarsPadding()
    ) {
        Text("UI Components List",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            color = Color.Blue
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text("Display", fontWeight = FontWeight.Bold)
        //Spacer(modifier = Modifier.height(3.dp))
        ItemCard("Text","Displays text"){ navController.navigate(Routes.ScreenText)}
        ItemCard("image", "Displays an image") { navController.navigate(Routes.ScreenIMG)}
        Text("Input", fontWeight = FontWeight.Bold)
        ItemCard("TextField", "Input field for text") { navController.navigate(Routes.ScreenTextField) }
        ItemCard("PasswordField", "input field for passswords") { navController.navigate(Routes.ScreenPassword) }
        Text("Layout", fontWeight = FontWeight.Bold)
        ItemCard("Column", "Arranges elements vetically") { navController.navigate(Routes.ScreenCol) }
        ItemCard("Row", "Arranges elements horizontally") { navController.navigate(Routes.ScreenRow) }
    }
}

@Preview(showBackground = true)
@Composable
fun Preview2() {
    Tuan3Theme {
        val nav = rememberNavController()
        ScreenUI(nav)
    }
}