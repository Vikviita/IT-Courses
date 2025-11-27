package com.vikvita.it_courses.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vikvita.it_courses.features.authorization.AuthScreen
import kotlinx.serialization.Serializable


@Composable
fun MainNavGraph(
    navHostController: NavHostController
){
    NavHost(
        navController = navHostController,
        startDestination = MainNavRoutes.AuthorizationRoute
    ){
        composable<MainNavRoutes.AuthorizationRoute>{
            AuthScreen {
                navHostController.navigate(MainNavRoutes.HomeRoute)
            }
        }
        composable<MainNavRoutes.HomeRoute>{

        }

    }

}


@Serializable
sealed interface MainNavRoutes{
    @Serializable
    data object AuthorizationRoute: MainNavRoutes
    @Serializable
    data object HomeRoute: MainNavRoutes
}