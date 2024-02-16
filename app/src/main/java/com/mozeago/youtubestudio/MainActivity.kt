package com.mozeago.youtubestudio

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mozeago.youtubestudio.ui.screen.CallUs
import com.mozeago.youtubestudio.ui.screen.Favorite
import com.mozeago.youtubestudio.ui.screen.Listen
import com.mozeago.youtubestudio.ui.screen.More
import com.mozeago.youtubestudio.ui.screen.Support
import com.mozeago.youtubestudio.ui.theme.YouTubeStudioTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            YouTubeStudioTheme {

                // A surface container using the 'background' color from the theme
                Scaffold(bottomBar = {
                    YouTubeStudioBottomNavigation(navController = navController)
                }, topBar = {
                    YouTubeStudioTopSearchBar()
                }) { paddingValues ->

                    NavHost(
                        navController = navController,
                        startDestination = Listen.route,
                        modifier = Modifier.padding(paddingValues)
                    ) {
                        composable(route = Listen.route) {
                            Listen()
                        }
                        composable(route = Favorite.route) {
                            Favorite()
                        }
                        composable(route = CallUs.route) {
                            CallUs()
                        }
                        composable(route = Support.route) {
                            Support()
                        }
                        composable(route = More.route) {
                            More()
                        }

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
    val navController = rememberNavController()
    YouTubeStudioTheme {
        Scaffold(bottomBar = {
            YouTubeStudioBottomNavigation(navController = navController)
        }, topBar = {
            YouTubeStudioTopSearchBar()
        }) { paddingValues ->
            NavHost(
                navController = navController,
                startDestination = Listen.route,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(route = Listen.route) {
                    Listen.screen
                }
                composable(route = Favorite.route) {
                    Favorite.screen
                }
                composable(route = CallUs.route) {
                    CallUs.screen
                }
                composable(route = Support.route) {
                    Support.screen
                }
                composable(route = More.route) {
                    More.screen
                }
            }

        }
    }
}
