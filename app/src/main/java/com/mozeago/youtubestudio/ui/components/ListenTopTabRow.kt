package com.mozeago.youtubestudio.ui.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mozeago.youtubestudio.R

@Composable
fun ListenTopTabRow(modifier: Modifier = Modifier) {
    val selectedTabIndex = remember { mutableIntStateOf(0) }
    TabRow(
        selectedTabIndex = selectedTabIndex.intValue,
        modifier = modifier
            .padding(top = 16.dp),
    ) {
        Tab(selected = true, onClick = {
            selectedTabIndex.intValue = 0
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_tv),
                contentDescription = "tv",
                modifier = modifier.padding(5.dp)
            )
        }
        Tab(selected = false, onClick = {
            selectedTabIndex.intValue = 1
        }) {
            Icon(painter = painterResource(id = R.drawable.ic_radio), contentDescription = "radio")
        }
    }
}