package com.example.tuan3

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = Routes.screenM, builder = {
                composable(Routes.screenM){ ScreenM(navController) }
                composable(Routes.screenUI){ ScreenUI(navController) }
                composable(Routes.ScreenText) { ScreenText(onBack = { navController.popBackStack() })}
                composable (Routes.ScreenIMG){ ScreenIMG(onBack = { navController.popBackStack() })}
                composable (Routes.ScreenCol){ ScreenCol(onBack = { navController.popBackStack() })}
                composable (Routes.ScreenRow){ ScreenRow(onBack = { navController.popBackStack() })}
                composable (Routes.ScreenTextField){ ScreenTextField(onBack = { navController.popBackStack() })}
            })
        }
    }
}