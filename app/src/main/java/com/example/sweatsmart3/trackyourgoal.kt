package com.example.sweatsmart3.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.sweatsmart3.R

@Composable
fun TrackYourGoalScreen(navController: NavController, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Image Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF00D600))
                .padding(top = 32.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_fitness_image), // Ensure this drawable exists
                contentDescription = "Fitness Image",
                modifier = Modifier
                    .size(550.dp),  // Adjust the size as needed
                contentScale = ContentScale.FillHeight
            )
        }

        // Text Section
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                text = "Track Your Goal",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(
                text = "Don't worry if you have trouble determining your goals, " +
                        "we can help you determine your goals and track your goals.",
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 16.dp),
                lineHeight = 20.sp
            )
        }

        // Circular Progress Button Section
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(28.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            CircularProgressButton(
                progress = 0.75f,
                onClick = { navController.navigate("getBurnScreen") } // Navigate to GetBurnScreen when clicked
            )
        }
    }
}

@Composable
fun CircularProgressButton(
    modifier: Modifier = Modifier,
    progress: Float = 0.75f,
    onClick: () -> Unit // Add onClick parameter to handle button clicks
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(100.dp) // Size of the whole component (matching the intended button size)
    ) {
        // Circular progress background
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawArc(
                brush = SolidColor(Color(0xFFB3E5FC)), // Light blue background color for the circle
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = androidx.compose.ui.graphics.drawscope.Stroke(width = 12.dp.toPx(), cap = StrokeCap.Round)
            )
        }
        Canvas(modifier = Modifier.fillMaxSize()) {
            drawArc(
                brush = SolidColor(Color(0xFF64B5F6)),
                startAngle = -90f,
                sweepAngle = progress * 360,
                useCenter = false,
                style = androidx.compose.ui.graphics.drawscope.Stroke(width = 12.dp.toPx(), cap = StrokeCap.Round)
            )
        }

        // Circular Button with Gradient
        Button(
            onClick = onClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            shape = CircleShape,
            contentPadding = PaddingValues(),
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF8ECAE6),
                                Color(0xFF219EBC)
                            )
                        ),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = ">",
                    fontSize = 32.sp,
                    color = Color.White
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TrackYourGoalScreenPreview() {
    val mockNavController = rememberNavController()
    TrackYourGoalScreen(navController = mockNavController)
}
@Preview(showBackground = true)
@Composable
fun CircularProgressButtonPreview() {
    CircularProgressButton(progress = 0.75f, onClick = {})
}
