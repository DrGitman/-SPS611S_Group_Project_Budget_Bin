package com.cscorner.budgetbin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.cscorner.budgetbin.inapp.DashboardScreen
import com.cscorner.budgetbin.inapp.ProfileScreen
import com.cscorner.budgetbin.onboarding.OnboardingScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppContent()
        }
    }
}

@Composable
fun AppContent() {
    val navController = rememberNavController()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        NavHost(navController = navController, startDestination = "onboarding") {
            composable("onboarding") {
                OnboardingScreen(
                    onGetStartedClick = { navController.navigate("signup") },
                    onSignInClick = { navController.navigate("signin") }
                )
            }
            composable("signin") {
                BudgetBinSignInScreen(navController = navController)
            }
            composable("signup") {
                BudgetBinSignUpScreen(navController = navController)
            }
            composable("dashboard") {
                DashboardScreen(navController = navController)
            }
            composable("profile") {
                ProfileScreen()
            }
        }
    }
}
