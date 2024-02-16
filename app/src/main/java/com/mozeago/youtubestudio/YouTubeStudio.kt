package com.mozeago.youtubestudio

import android.util.Log
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mozeago.youtubestudio.ui.screen.CallUs
import com.mozeago.youtubestudio.ui.screen.Favorite
import com.mozeago.youtubestudio.ui.screen.Listen
import com.mozeago.youtubestudio.ui.screen.More
import com.mozeago.youtubestudio.ui.screen.Support

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
            .padding(16.dp)
    )
}

@Composable
fun YouTubeStudioBottomNavigation(
    modifier: Modifier = Modifier, navController: NavHostController
) {
    val selectedDestination = remember {
        mutableStateOf(Listen.route)
    }
    Row {
        NavigationBar(modifier = modifier.fillMaxWidth()) {
            TOP_LEVEL_DESTINATIONS.forEach { youTubeStudioTopLevelDestinations ->
                NavigationBarItem(selected = selectedDestination.value == youTubeStudioTopLevelDestinations.route,
                    onClick = {
                        selectedDestination.value = youTubeStudioTopLevelDestinations.route
                        navController.navigate(youTubeStudioTopLevelDestinations.route)
                        Log.d("ROUTE",youTubeStudioTopLevelDestinations.route)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = youTubeStudioTopLevelDestinations.selectedIcon),
                            contentDescription = stringResource(id = youTubeStudioTopLevelDestinations.iconTextId)
                        )
                    }, label = {
                        Text(text = stringResource(id = youTubeStudioTopLevelDestinations.iconTextId))
                    })
            }

        }
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