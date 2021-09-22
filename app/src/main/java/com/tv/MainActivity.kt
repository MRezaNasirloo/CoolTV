package com.tv

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.tv.telero.BottomTabs
import com.tv.telero.Tab
import com.tv.telero.theme.CoolTvTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val tabs = listOf(
                Tab(title = "Home", icon = com.tv.telero.R.drawable.ic_home_24),
                Tab(title = "Profile", icon = com.tv.telero.R.drawable.ic_person_24),
            ).map { tab ->
                tab.copy(
                    selected = {
                        navBackStackEntry?.destination
                            ?.hierarchy
                            ?.any { it.route == tab.title } == true
                    },
                    click = {
                        navController.navigate(tab.title) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
            CoolTvTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(bottomBar = {
                        BottomTabs(tabs = tabs)
                    }) {
                        Navigation(navController)
                    }
                }
            }
        }
    }
}
