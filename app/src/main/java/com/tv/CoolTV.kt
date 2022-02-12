package com.tv

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.primarySurface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tv.telero.BottomTabs
import com.tv.telero.R
import com.tv.telero.Tab
import com.tv.telero.theme.CoolTvTheme
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@ExperimentalCoroutinesApi
@FlowPreview
@Composable
fun CoolTV() {
    val navController = rememberNavController()

    val click = { route: String ->
        navController.navigate(route) {
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    val currentEntry by navController.currentBackStackEntryAsState()

    val tabs = listOf(
        Tab(title = "Home", icon = R.drawable.ic_home_24),
        Tab(title = "Profile", icon = R.drawable.ic_person_24),
        Tab(title = "Setting", icon = R.drawable.ic_settings_24),
    )

    CoolTvTheme {
        SystemUi()
        Surface(color = MaterialTheme.colors.background) {
            Scaffold(
                bottomBar = {
                    BottomTabs(
                        tabs = tabs,
                        selected = currentEntry?.destination?.route,
                        click = click
                    )
                }
            ) {
                Navigation(navController)
            }
        }
    }
}

@Composable
private fun SystemUi() {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = MaterialTheme.colors.isLight
    val primary = MaterialTheme.colors.primarySurface
    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )

        systemUiController.setNavigationBarColor(
            color = primary,
        )
    }
}
