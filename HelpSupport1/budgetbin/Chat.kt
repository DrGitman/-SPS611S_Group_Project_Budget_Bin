package com.example.budgetbin

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import androidx.navigation.NavHostController
import java.text.SimpleDateFormat
import java.util.*

data class ChatMessage(val text: String, val isUser: Boolean, val timestamp: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatPage(navController: NavHostController) {
    var userInput by remember { mutableStateOf("") }
    val messages = remember { mutableStateListOf<ChatMessage>() }

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
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                TextField(
                    value = userInput,
                    onValueChange = { userInput = it },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    placeholder = { Text("Type your message...") }
                )
                Button(onClick = {
                    if (userInput.isNotBlank()) {
                        val timestamp = getCurrentTimestamp()
                        messages.add(ChatMessage(userInput, true, timestamp))
                        messages.add(ChatMessage(generateResponse(userInput), false, getCurrentTimestamp()))
                        userInput = ""
                    }
                }) {
                    Text("Send")
                }
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // Icon and description
            Icon(
                imageVector = Icons.Default.Chat,
                contentDescription = "Chat",
                tint = Color(0xFF4CAF50), // Green
                modifier = Modifier
                    .size(64.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Text(
                text = "Do you have a question or concern? Our team is just a message away — chat with us through the help of our team and a smart assistant — chat with us for quick and helpful support!",
                fontSize = 14.sp,
                color = Color.LightGray,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
            )

            // Messages
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                items(messages) { message ->
                    ChatBubble(message)
                }
            }
        }
    }
}

@Composable
fun ChatBubble(message: ChatMessage) {
    val bubbleColor = if (message.isUser) Color(0xFF4CAF50) else Color(0xFFEEEEEE)
    val textColor = if (message.isUser) Color.White else Color.Black
    val alignment = if (message.isUser) Alignment.End else Alignment.Start

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        horizontalAlignment = alignment
    ) {
        Box(
            modifier = Modifier
                .background(color = bubbleColor, shape = RoundedCornerShape(12.dp))
                .padding(12.dp)
                .widthIn(max = 280.dp)
        ) {
            Text(text = message.text, color = textColor)
        }
        Text(
            text = message.timestamp,
            fontSize = 10.sp,
            color = Color.Gray,
            modifier = Modifier.padding(top = 2.dp)
        )
    }
}

@SuppressLint("SimpleDateFormat")
fun getCurrentTimestamp(): String {
    val sdf = SimpleDateFormat("HH:mm, MMM d")
    return sdf.format(Date())
}

// Placeholder for AI response
fun generateResponse(input: String): String {
    // This is where the MLC LLM will later be used
    return "Thanks for your message. We'll get back to you shortly!"
}
