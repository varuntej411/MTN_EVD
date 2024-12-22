package com.mtn.evd.navgraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.mtn.evd.presentation.screens.CountrySelectScreen
import com.mtn.evd.presentation.screens.LoginScreen
import com.mtn.evd.presentation.screens.SplashScreen

fun NavGraphBuilder.authenticationNavGraph(navController: NavHostController) {
    navigation(
        route = RootNavGraph.AUTH_GRAPH,
        startDestination = Screens.SplashScreen.route
    ) {

        composable(route = Screens.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screens.CountrySelectScreen.route) {
            CountrySelectScreen(navController = navController)
        }

        composable(route = Screens.LoginScreen.route) {
           LoginScreen(navController = navController)
        }
    }
}