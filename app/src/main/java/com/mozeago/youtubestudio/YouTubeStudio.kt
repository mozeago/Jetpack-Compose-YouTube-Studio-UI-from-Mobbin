package com.mozeago.youtubestudio

import android.content.res.Configuration
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mozeago.youtubestudio.ui.screen.CallUs
import com.mozeago.youtubestudio.ui.screen.Favorite
import com.mozeago.youtubestudio.ui.screen.Listen
import com.mozeago.youtubestudio.ui.screen.More
import com.mozeago.youtubestudio.ui.screen.Support
import com.mozeago.youtubestudio.ui.theme.YouTubeStudioTheme
import java.util.Locale

@Composable
fun YouTubeStudioTopSearchBar(modifier: Modifier = Modifier) {

    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription = null)
        }, colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent
        ), placeholder = {
            Text(text = stringResource(id = R.string.app_search))
        }, modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .padding(16.dp, top = 30.dp)
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun YouTubeStudioBottomNavigation(
    modifier: Modifier = Modifier, navController: NavHostController
) {
    val selectedDestination = remember {
        mutableStateOf(Listen.route)
    }
    var selectedIndex by rememberSaveable {
        mutableIntStateOf(0)
    }
    Row {
        NavigationBar(
            modifier = modifier
                .fillMaxWidth()
                .shadow(elevation = 24.dp, shape = MaterialTheme.shapes.extraSmall),
            containerColor = Color.White
        ) {
            TOP_LEVEL_DESTINATIONS.forEachIndexed { index, youTubeStudioTopLevelDestinations ->
                NavigationBarItem(
                    selected = selectedDestination.value == youTubeStudioTopLevelDestinations.route,
                    onClick = {
                        selectedIndex = index
                        selectedDestination.value = youTubeStudioTopLevelDestinations.route
                        navController.navigate(youTubeStudioTopLevelDestinations.route)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = youTubeStudioTopLevelDestinations.selectedIcon),
                            contentDescription = stringResource(id = youTubeStudioTopLevelDestinations.iconTextId),
                        )
                    }, label = {
                        Text(
                            text = stringResource(id = youTubeStudioTopLevelDestinations.iconTextId).replaceFirstChar {
                                if (it.isLowerCase()) it.titlecase(
                                    Locale.getDefault()
                                ) else it.toString()
                            },
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            style = MaterialTheme.typography.bodyMedium,
                            fontStyle = FontStyle.Normal,
                            fontWeight = if (selectedDestination.value == youTubeStudioTopLevelDestinations.route) FontWeight.W900 else FontWeight.W400,
                            fontFamily = FontFamily(
                                Font(R.font.basier_square_regular)
                            )
                        )
                    },
                    colors = NavigationBarItemDefaults.colors(
                        selectedIconColor = Color(0XFFE80000),
                        selectedTextColor = Color(0XFFE80000),
                        indicatorColor = Color(0XFFffffff)

                    )
                )

            }

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES, name = "DefaultPreviewDark", showBackground = true
)
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_NO, name = "DefaultPreviewLight", showBackground = true
)
@Composable
fun YouTubeStudioBottomNavigationPreview() {
    val navController = rememberNavController()
    YouTubeStudioTheme {
        YouTubeStudioBottomNavigation(navController = navController)
    }
}
interface YouTubeStudioTopLevelDestinations {
    val route: String
    val screen: @Composable () -> Unit
    val iconTextId: Int
    val selectedIcon: Int
    val unSelectedIcon: Int
}

object Listen : YouTubeStudioTopLevelDestinations {
    override val route: String
        get() = "listen"
    override val screen: @Composable () -> Unit
        @RequiresApi(Build.VERSION_CODES.Q)
        get() = {
            Listen()
        }
    override val iconTextId: Int
        get() = R.string.app_route_listen
    override val selectedIcon: Int
        get() = R.drawable.ic_listen
    override val unSelectedIcon: Int
        get() = R.drawable.ic_listen

}

object Favorite : YouTubeStudioTopLevelDestinations {
    override val route: String
        get() = "favorites"
    override val screen: @Composable () -> Unit
        get() = {
            Favorite()
        }
    override val iconTextId: Int
        get() = R.string.app_route_favorites
    override val selectedIcon: Int
        get() = R.drawable.ic_favorite
    override val unSelectedIcon: Int
        get() = R.drawable.ic_favorite

}

object Support : YouTubeStudioTopLevelDestinations {
    override val route: String
        get() = "support"
    override val screen: @Composable () -> Unit
        get() = {
            Support()
        }
    override val iconTextId: Int
        get() = R.string.app_route_support
    override val selectedIcon: Int
        get() = R.drawable.ic_give
    override val unSelectedIcon: Int
        get() = R.drawable.ic_give

}

object CallUs : YouTubeStudioTopLevelDestinations {
    override val route: String
        get() = "one_on_one"
    override val screen: @Composable () -> Unit
        get() = {
            CallUs()
        }
    override val iconTextId: Int
        get() = R.string.app_route_one_on_one
    override val selectedIcon: Int
        get() = R.drawable.ic_call_us
    override val unSelectedIcon: Int
        get() = R.drawable.ic_call_us

}

object More : YouTubeStudioTopLevelDestinations {
    override val route: String
        get() = "more"
    override val screen: @Composable () -> Unit
        get() = {
            More()
        }
    override val iconTextId: Int
        get() = R.string.app_route_more
    override val selectedIcon: Int
        get() = R.drawable.ic_more
    override val unSelectedIcon: Int
        get() = R.drawable.ic_more

}

val TOP_LEVEL_DESTINATIONS = listOf(
    Listen, Favorite, Support, CallUs, More
)