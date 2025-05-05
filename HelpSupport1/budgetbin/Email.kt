package com.example.budgetbin

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailPage(navController: NavHostController) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        },
        bottomBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        val emailIntent = Intent(Intent.ACTION_SENDTO).apply {
                            data = Uri.parse("mailto:support@budgetbin.com.na")
                        }
                        context.startActivity(emailIntent)
                    },
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("TAP TO SEND EMAIL", color = Color.White)
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = "Email Icon",
                tint = Color(0xFF4CAF50),
                modifier = Modifier
                    .size(64.dp)
                    .padding(top = 16.dp)
            )

            Text(
                text = "For any inquiries or support, simply send us an email at support@budgetbin.com.na, and our team will get back to you within 24 hours.",
                fontSize = 14.sp,
                color = Color.LightGray,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 24.dp)
            )

            Text(
                text = "Operating Hours:\nMonday – Friday: 8:00 AM – 5:00 PM",
                fontSize = 14.sp,
                color = Color.DarkGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
