package com.mozeago.youtubestudio.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mozeago.youtubestudio.R

@RequiresApi(Build.VERSION_CODES.Q)
@Composable
fun ListenTopTabRow(modifier: Modifier = Modifier) {
    val selectedTabIndex = remember { mutableIntStateOf(0) }
    TabRow(
        selectedTabIndex = selectedTabIndex.intValue,
        modifier = modifier
            .padding(bottom = 16.dp),
        containerColor = Color(0XFFE80000)
    ) {
        Tab(
            selected = true,
            onClick = {
                selectedTabIndex.intValue = 0
            },
            selectedContentColor = if (selectedTabIndex.intValue == 0) {
                Color.White
            } else {
                Color.Black
            },
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(5.dp))
                Icon(
                    painter = painterResource(id = R.drawable.ic_tv),
                    contentDescription = "television",
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = stringResource(id = R.string.app_tv).uppercase(),
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = if (selectedTabIndex.intValue == 0)
                        FontWeight.Bold else
                        FontWeight.W400,
                    color = if (selectedTabIndex.intValue == 0) Color.White else Color.Black,
                    fontStyle = FontStyle.Normal,
                    fontSize = 16.sp,
                    lineHeight = 24.sp,
                    fontFamily = FontFamily(
                        Font(R.font.basier_square_regular)
                    )
                )
                Spacer(modifier = Modifier.height(5.dp))
            }
        }
        Tab(
            selected = true,
            onClick = {
                selectedTabIndex.intValue = 1
            },
            selectedContentColor = if (selectedTabIndex.intValue == 1) {
                Color.White
            } else {
                Color.Black
            }

        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_radio),
                contentDescription = "radio"
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = stringResource(id = R.string.app_radio).uppercase(),
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = if (selectedTabIndex.intValue == 1)
                    FontWeight.Bold else
                    FontWeight.Normal,
                fontSize = 16.sp,
                lineHeight = 24.sp,
                color = if (selectedTabIndex.intValue == 1) Color.White else Color.DarkGray,
                fontFamily = FontFamily(
                    Font(R.font.basier_square_regular)
                )
            )
        }
    }
}