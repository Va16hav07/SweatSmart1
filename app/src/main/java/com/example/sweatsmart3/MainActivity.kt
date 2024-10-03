package com.example.sweatsmart3

import LoginScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sweatsmart.ui.EatWell
import com.example.sweatsmart3.ui.*
import com.example.sweatsmart3.ui.theme.SweatSmartTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SweatSmartTheme {
                val navController = rememberNavController()

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "previewScreen",  // Starting destination
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("previewScreen") {
                            PreviewScreen(navController = navController)
                        }
                        composable("trackYourGoal") {
                            TrackYourGoalScreen(navController = navController)
                        }
                        composable("getBurnScreen") {
                            GetBurnScreen(navController = navController)
                        }
                        composable("eatWell") {
                            EatWell(navController = navController)
                        }
                        composable("sleepQuality") {
                            SleepQuality(navController = navController)
                        }
                        // Add LoginScreen route here
                        composable("loginScreen") {
                            LoginScreen(navController = navController)
                        }
                        composable("register"){
                            RegisterScreen(navController=navController)
                        }
                    }
                }
            }
        }
    }
}
