package com.tv.telero

import androidx.annotation.DrawableRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun BottomTabs(modifier: Modifier = Modifier, tabs: List<Tab>) {
    BottomNavigation(modifier = modifier) {
        var selectedItem by rememberSaveable { mutableStateOf(0) }
        tabs.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = item.icon),
                        contentDescription = item.contentDescription
                    )
                },
                label = { Text(item.title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}

data class Tab(
    val title: String,
    val contentDescription: String = title,
    @DrawableRes val icon: Int
)
