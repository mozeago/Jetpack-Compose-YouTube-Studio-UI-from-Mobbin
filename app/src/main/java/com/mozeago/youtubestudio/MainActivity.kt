package com.mozeago.youtubestudio

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.mozeago.youtubestudio.ui.theme.YouTubeStudioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YouTubeStudioTheme {
                // A surface container using the 'background' color from the theme
                Scaffold(bottomBar = {
                    YouTubeStudioBottomNavigation()
                }, topBar = {
                    YouTubeStudioTopSearchBar()
                }) { paddingValues ->
                    Column(modifier = Modifier.padding(paddingValues)) {

                    }

                }
            }
        }
    }
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES, name = "DefaultPreviewDark", showBackground = true
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO, name = "DefaultPreviewLight", showBackground = true
)
@Composable
fun YouTubeStudioPreview() {
    YouTubeStudioTheme {
        Scaffold(bottomBar = {
            YouTubeStudioBottomNavigation()
        }, topBar = {
            YouTubeStudioTopSearchBar()
        }) { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Content page",
                    style = MaterialTheme.typography.displayLarge
                )
            }

        }
    }
}
