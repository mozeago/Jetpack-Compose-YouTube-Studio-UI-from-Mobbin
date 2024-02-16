package com.mozeago.youtubestudio

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
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
    modifier: Modifier = Modifier
) {
    val selectedDestination = remember {
        mutableStateOf(YouTubeStudioRoutes.LISTEN)
    }
    Row {
        NavigationBar(modifier = modifier.fillMaxWidth()) {
            TOP_LEVEL_DESTINATIONS.forEach { youTubeStudioTopLevelDestinations ->
                NavigationBarItem(selected = selectedDestination.value == youTubeStudioTopLevelDestinations.route,
                    onClick = {
                        selectedDestination.value = youTubeStudioTopLevelDestinations.route
                    },
                    icon = {
                        Icon(
                            painter = painterResource(id = youTubeStudioTopLevelDestinations.selectedIcon),
                            contentDescription = stringResource(id = youTubeStudioTopLevelDestinations.iconTextId)
                        )
                    },
                    label = {
                        Text(text = stringResource(id = youTubeStudioTopLevelDestinations.iconTextId))
                    })
            }

        }
    }
}

object YouTubeStudioRoutes {
    const val LISTEN = "listen"
    const val FAVORITES = "favorites"
    const val SUPPORT = "support"
    const val ONE_ON_ONE = "one_on_one"
    const val MORE = "more"
}

data class YouTubeStudioTopLevelDestinations(
    val route: String,
    @StringRes val iconTextId: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unSelectedIcon: Int
)

val TOP_LEVEL_DESTINATIONS = listOf(
    YouTubeStudioTopLevelDestinations(
        route = YouTubeStudioRoutes.LISTEN,
        iconTextId = R.string.app_route_listen,
        selectedIcon = R.drawable.ic_listen,
        unSelectedIcon = R.drawable.ic_listen
    ),
    YouTubeStudioTopLevelDestinations(
        route = YouTubeStudioRoutes.FAVORITES,
        iconTextId = R.string.app_route_favorites,
        selectedIcon = R.drawable.ic_favorite,
        unSelectedIcon = R.drawable.ic_favorite
    ),
    YouTubeStudioTopLevelDestinations(
        route = YouTubeStudioRoutes.SUPPORT,
        iconTextId = R.string.app_route_support,
        selectedIcon = R.drawable.ic_give,
        unSelectedIcon = R.drawable.ic_give
    ),
    YouTubeStudioTopLevelDestinations(
        route = YouTubeStudioRoutes.ONE_ON_ONE,
        iconTextId = R.string.app_route_one_one_one,
        selectedIcon = R.drawable.ic_call_us,
        unSelectedIcon = R.drawable.ic_call_us
    ),
    YouTubeStudioTopLevelDestinations(
        route = YouTubeStudioRoutes.MORE,
        iconTextId = R.string.app_route_more,
        selectedIcon = R.drawable.ic_more,
        unSelectedIcon = R.drawable.ic_more
    ),
)