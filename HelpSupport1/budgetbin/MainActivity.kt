package com.example.budgetbin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.*

import com.example.budgetbin.ui.theme.BudgetBinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BudgetBinTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "welcome") {
                    composable("welcome") {
                        WelcomeScreen(navController)
                    }
                    composable("faq") {
                        FAQ(navController)
                    }
                    composable("chat") {
                        ChatPage(navController = navController)
                    }
                    composable("call") {
                        CallSupportScreen(navController=navController)
                    }
                    composable("email") {
                        EmailPage(navController)
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {},
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.primaryContainer)
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Icon at the top
            Image(
                painter = painterResource(id = R.drawable.faq),
                contentDescription = "FAQ Icon",
                modifier = Modifier
                    .size(100.dp)
                    .padding(bottom = 16.dp)
            )

            // Title
            Text(
                text = "How can we help you",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            // Subtitle
            Text(
                text = "Get answers, troubleshooting tips or contact support - We're here to help",
                fontSize = 14.sp,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(top = 8.dp, bottom = 16.dp),
                textAlign = TextAlign.Center
            )

            // Navigation options
            SupportOption("FAQ", Icons.Default.HelpOutline) {
                navController.navigate("faq")
            }
            SupportOption("Chat", Icons.Default.Chat) {
                navController.navigate("chat")
            }
            SupportOption("Call Support", Icons.Default.Call) {
                navController.navigate("call")
            }
            SupportOption("Email", Icons.Default.Email) {
                navController.navigate("email")
            }
        }
    }
}

@Composable
fun SupportOption(label: String, icon: ImageVector, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF5F5F5))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Icon(icon, contentDescription = label, tint = Color(0xFF4CAF50))
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = label, fontSize = 16.sp, fontWeight = FontWeight.Medium)

        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SupportPage(title: String) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(title) }
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text("Coming Soon: $title")
        }
    }
}
