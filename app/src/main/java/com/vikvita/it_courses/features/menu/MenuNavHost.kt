package com.vikvita.it_courses.features.menu

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable

@Composable
fun MenuNavHost(
    navController: NavHostController,
    scaffoldPaddingValues: PaddingValues,
) {
    NavHost(
        modifier = Modifier.padding(scaffoldPaddingValues),
        navController = navController,
        startDestination = MenuRoutes.HomeRoute
    ) {
        composable<MenuRoutes.HomeRoute> {

        }
        composable<MenuRoutes.FavouriteRoute> {

        }
        composable<MenuRoutes.ProfileRoute> {

        }
    }
}

@Serializable
sealed interface MenuRoutes {
    @Serializable
    data object HomeRoute : MenuRoutes

    @Serializable
    data object FavouriteRoute : MenuRoutes

    @Serializable
    data object ProfileRoute : MenuRoutes
}