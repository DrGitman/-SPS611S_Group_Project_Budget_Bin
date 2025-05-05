package com.example.budgetbin

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FAQ(navController: NavHostController) {
    val faqItems = listOf(
        "What is Budget Bin?" to "Budget Bin is an AI-driven mobile app that helps users find the best deals for goods in close proximity to them.",
        "How do I create a budget?" to "Go to the Budget section, tap 'Create Budget', then enter your income and spending limits for each category.",
        "Can I link my bank account?" to "Yes. Navigate to Settings > Linked Accounts to securely connect your bank via Plaid.",
        "Is my financial data safe?" to "Absolutely. We use 256-bit encryption and never store your bank credentials.",
        "Can I use Budget Bin offline?" to "Yes, most features work offline. Sync will happen when you're back online.",
        "How do I reset my password?" to "Tap 'Forgot Password' on the login screen and follow the instructions sent to your email.",
        "What happens when I exceed my budget?" to "You'll receive a warning, and the overspent category will be highlighted so you can adjust accordingly."
    )

    var expandedItem by remember { mutableStateOf<String?>(null) }

    Scaffold(
        topBar = {
            Column {
                // Icon above the TopAppBar
                Image(
                    painter = painterResource(id = R.drawable.faq),
                    contentDescription = "FAQ Image",
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .align(Alignment.CenterHorizontally)
                        .size(80.dp)
                )

                TopAppBar(
                    title = { Text("Frequently Asked Questions") },
                    navigationIcon = {
                        IconButton(onClick = { navController.navigateUp() }) {
                            Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                        }
                    }
                )
            }
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            // Subtitle
            Text(
                text = "Need help? Our FAQ has you covered—browse common questions and solutions",
                fontSize = 14.sp,
                color = Color.LightGray,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                        .padding(bottom = 16.dp)
            )

            // FAQ Items
            faqItems.forEach { (question, answer) ->
                FAQItem(
                    question = question,
                    answer = answer,
                    isExpanded = expandedItem == question,
                    onClick = {
                        expandedItem = if (expandedItem == question) null else question
                    }
                )
            }
        }
    }
}

@Composable
fun FAQItem(question: String, answer: String, isExpanded: Boolean, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = question,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                style = MaterialTheme.typography.bodyLarge
            )
            Icon(
                imageVector = if (isExpanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                contentDescription = null
            )
        }

        if (isExpanded) {
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = answer,
                fontSize = 13.sp,
                color = Color.LightGray,
                style = MaterialTheme.typography.bodySmall
            )
        }

        Divider(modifier = Modifier.padding(top = 8.dp))
    }
}
