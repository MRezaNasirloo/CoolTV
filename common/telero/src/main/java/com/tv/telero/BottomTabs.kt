package com.tv.telero

import androidx.annotation.DrawableRes
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun BottomTabs(modifier: Modifier = Modifier, tabs: List<Tab>) {
    BottomNavigation(modifier = modifier) {
        tabs.forEach { tab ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = ImageVector.vectorResource(id = tab.icon),
                        contentDescription = tab.title
                    )
                },
                label = { Text(tab.title, maxLines = 1, overflow = TextOverflow.Ellipsis) },
                selected = tab.selected(),
                onClick = tab.click,
            )
        }
    }
}

data class Tab(
    val title: String,
    @DrawableRes val icon: Int,
    val selected: () -> Boolean = { false },
    val click: () -> Unit = {},
)
