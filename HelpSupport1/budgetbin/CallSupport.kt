package com.example.budgetbin

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CallSupportScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    IconButton(onClick = { navController.navigate("welcome") }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Green Phone Icon
            Icon(
                imageVector = Icons.Default.Call,
                contentDescription = "Call Icon",
                tint = Color(0xFF4CAF50), // Green color
                modifier = Modifier
                    .size(80.dp)
                    .padding(bottom = 16.dp)
            )

            // Heading
            Text(
                text = "Call Support",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = Color.Black
            )

            // Description
            Text(
                text = "Our support team is just one call away. Whether it's a question about app features or finding deals close to you – we're here to help you, right away.",
                fontSize = 14.sp,
                color = Color.LightGray,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            // Contact Info
            Text("Budget Bin Customer Support", fontWeight = FontWeight.Medium, fontSize = 16.sp, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(4.dp))
            Text("Office Line: +264 61 234 567", textAlign = TextAlign.Center)
            Text("WhatsApp: +264 81 234 5678", textAlign = TextAlign.Center)

            Spacer(modifier = Modifier.height(24.dp))

            // Call Button
            Button(onClick = {
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:+26461234567")
                navController.context.startActivity(intent)
            },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))) {
                Icon(Icons.Default.Phone, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Call Office Line")
            }

            Spacer(modifier = Modifier.height(12.dp))

            // WhatsApp Button
            Button(onClick = {
                val uri = Uri.parse("https://wa.me/264812345678")
                val intent = Intent(Intent.ACTION_VIEW, uri)
                navController.context.startActivity(intent)
            },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))) {
                Icon(Icons.Default.Chat, contentDescription = null)
                Spacer(modifier = Modifier.width(8.dp))
                Text("Message on WhatsApp")
            }

            Spacer(modifier = Modifier.height(12.dp))



            Text(
                text = "Operating Hours : Monday - Friday 8:00 AM - 5:00 PM",
                fontSize = 14.sp,
                color = Color.Black,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}
