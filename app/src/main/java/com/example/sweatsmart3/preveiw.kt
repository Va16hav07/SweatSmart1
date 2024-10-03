package com.example.sweatsmart3.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // Updated imports
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun PreviewScreen(navController: NavController, modifier: Modifier = Modifier) {
    val systemUiController = rememberSystemUiController()

    SideEffect {
        // Hides the status bar
        systemUiController.isStatusBarVisible = false
        systemUiController.setSystemBarsColor(
            color = Color.Transparent // Ensures the status bar blends with the background
        )
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF00D600)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .align(Alignment.TopCenter)
                .padding(top = 360.dp)
        ) {
            Text(
                text = "Sweat Smart",
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Empower-Train-Thrive",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Gray
            )
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 40.dp)
        ) {
            Button(
                onClick = { navController.navigate("trackYourGoal") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(58.dp)
            ) {
                Text(
                    text = "Get Started",
                    fontSize = 18.sp,
                    color = Color(0xFF00D600),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}
