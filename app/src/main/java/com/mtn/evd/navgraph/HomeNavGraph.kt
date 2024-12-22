package com.mtn.evd.navgraph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mtn.evd.presentation.screens.home.HomeScreen
import com.mtn.evd.presentation.screens.reports.ReportsScreen
import com.mtn.evd.presentation.screens.transactions.TransactionsScreen

@Composable
fun HomeNavGraph(navController: NavHostController, innerPaddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        route = RootNavGraph.HOME_GRAPH,
        startDestination = Screens.HomeScreen.route
    ) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navController = navController, innerPaddingValues = innerPaddingValues)
        }

        composable(route = Screens.TransactionsScreen.route) {
            TransactionsScreen(navController = navController, innerPaddingValues = innerPaddingValues)
        }

        composable(route = Screens.ReportsScreen.route) {
            ReportsScreen(navController = navController, innerPaddingValues = innerPaddingValues)
        }
    }
}