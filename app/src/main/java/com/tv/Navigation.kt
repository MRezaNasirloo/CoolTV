package com.tv

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.tv.trending.TrendingScreen
import org.koin.androidx.viewmodel.ext.android.getViewModel

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            TrendingScreen(it.getViewModel())
        }
        composable("Profile") { Text("Profile") }
        composable("Setting") { Text("Setting") }
    }
}
