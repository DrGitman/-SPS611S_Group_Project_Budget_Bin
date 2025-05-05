package com.cscorner.budgetbin.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.cscorner.budgetbin.BudgetBinSignInScreen
import com.cscorner.budgetbin.R

@Composable
fun OnboardingScreen(
    onGetStartedClick: () -> Unit,
    onSignInClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        // Logo or image
        Image(
            painter = painterResource(id = R.drawable.onboarding_image), // Replace with your onboarding image
            contentDescription = "Onboarding Image",
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Title
        Text(
            text = "Budget Bin.",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF0C6C3F), // Dark Green
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Subtitle
        Text(
            text = "Smart Shopping Starts Here!",
            fontSize = 20.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Description
        Text(
            text = "Easily compare prices, track deals, and shop within your budget",
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Get Started Button
        Button(
            onClick = onGetStartedClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF0C6C3F) // Dark Green
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Get Started", fontSize = 16.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Sign In Button
        OutlinedButton(
            onClick = onSignInClick,
            border = ButtonDefaults.outlinedButtonBorder,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "I Already Have an Account", fontSize = 16.sp, color = Color(0xFF0C6C3F))
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreenPreview() {
    OnboardingScreen(onGetStartedClick = {}, onSignInClick = {})
}

