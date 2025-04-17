package com.yourappname // ← replace with your actual package name

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.BudgetBin.signin.BudgetBinSignInScreen


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
    Surface(
        color = MaterialTheme.colorScheme.background
    ) {
        BudgetBinSignInScreen()
    }
}
