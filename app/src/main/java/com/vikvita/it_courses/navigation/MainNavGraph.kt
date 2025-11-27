package com.vikvita.it_courses.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable


@Composable
fun MainNavGraph(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination = MainNavRoutes.AuthorizationRoute
    ){
        composable<MainNavRoutes.AuthorizationRoute>{  }

    }

}


@Serializable
sealed interface MainNavRoutes{
    @Serializable
    data object AuthorizationRoute: MainNavRoutes
}