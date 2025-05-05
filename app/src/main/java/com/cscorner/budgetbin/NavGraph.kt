package com.cscorner.budgetbin

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "signin") {
        composable("signin") {
            BudgetBinSignInScreen(navController)
        }
        composable("signup") {
            BudgetBinSignUpScreen(navController)
        }
    }
}