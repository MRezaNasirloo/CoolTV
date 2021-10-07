package com.tv

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Parcelable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.core.net.toUri
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.NavDeepLinkRequest
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.cooltv.movie.MovieScreen
import com.tv.navigation.movie.entity.Ids
import com.tv.trending.TrendingScreen
import org.koin.androidx.viewmodel.ext.android.getViewModel
import org.koin.core.parameter.parametersOf

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            TrendingScreen(it.getViewModel()) { ids ->
                navController.navigate("Movie", ids)
            }
        }
        composable("Profile") { Text("Profile") }
        composable("Setting") { Text("Setting") }
        composable("Movie") {
            val ids: Ids = it.requiredArg()
            MovieScreen(ids, it.getViewModel { parametersOf(ids) })
        }
    }
}

internal fun NavController.navigate(route: String, arg: Parcelable) {
    navigate(route)
    requireNotNull(currentBackStackEntry?.arguments).apply {
        putParcelable("cool_tv_arg", arg)
    }
}

internal inline fun <reified T : Parcelable> NavBackStackEntry.requiredArg(): T {
    return requireNotNull(arguments) { "arguments bundle is null" }.run {
        requireNotNull(getParcelable("cool_tv_arg")) { "argument for ${T::class} is null" }
    }
}

internal fun NavController.navigate(
    route: String,
    args: Bundle,
    navOptions: NavOptions? = null,
) {
    @SuppressLint("RestrictedApi")
    val routeLink = NavDeepLinkRequest
        .Builder
        .fromUri(NavDestination.createRoute(route).toUri())
        .build()

    val deepLinkMatch = graph.matchDeepLink(routeLink)
    if (deepLinkMatch != null) {
        val destination = deepLinkMatch.destination
        val id = destination.id
        navigate(id, args, navOptions)
    } else {
        navigate(route, navOptions)
    }
}
