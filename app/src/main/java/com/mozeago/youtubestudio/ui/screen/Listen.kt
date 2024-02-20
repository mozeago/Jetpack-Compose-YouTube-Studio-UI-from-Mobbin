package com.mozeago.youtubestudio.ui.screen

import android.os.Build
import androidx.annotation.RequiresApi
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

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun Listen(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    ListenTopTabRow()
//    YouTubeStudioTopSearchBar()
    Column(
        modifier = modifier.padding(100.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = "Listen", style = MaterialTheme.typography.displayLarge)
    }
}