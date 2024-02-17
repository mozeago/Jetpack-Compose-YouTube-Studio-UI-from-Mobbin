package com.mozeago.youtubestudio.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.mozeago.youtubestudio.ui.components.ListenTopTabRow

@Composable
fun Listen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    ListenTopTabRow()
    Spacer(modifier = modifier.height(16.dp))
//    YouTubeStudioTopSearchBar()
    Column(
        modifier = modifier.padding(50.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Listen", style = MaterialTheme.typography.displayLarge)
    }
}