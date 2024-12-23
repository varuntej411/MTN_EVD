package com.mtn.evd.navgraph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mtn.evd.presentation.screens.home.HomeScreen
import com.mtn.evd.presentation.screens.reports.ReportsScreen
import com.mtn.evd.presentation.screens.transactions.TransactionsScreen
import com.mtn.evd.presentation.screens.transactions.subscreens.PurchaseScreen
import com.mtn.evd.presentation.screens.transactions.subscreens.TopUpScreen
import com.mtn.evd.presentation.screens.transactions.subscreens.TransferScreen

@Composable
fun HomeNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = RootNavGraph.HOME_GRAPH,
        startDestination = Screens.HomeScreen.route
    ) {
        composable(route = Screens.HomeScreen.route) {
            HomeScreen(navController = navController, innerPaddingValues = PaddingValues())
        }

        composable(route = Screens.TransactionsScreen.route) {
            TransactionsScreen(navController = navController)
        }

        composable(route = Screens.ReportsScreen.route) {
            ReportsScreen(navController = navController, innerPaddingValues = PaddingValues())
        }

        composable(route = Screens.TopUpScreen.route) {
            TopUpScreen(navController = navController, innerPaddingValues = PaddingValues())
        }
        composable(route = Screens.TransferScreen.route) {
            TransferScreen(navController = navController, innerPaddingValues = PaddingValues())
        }
        composable(route = Screens.PurchaseScreen.route) {
            PurchaseScreen(navController = navController, innerPaddingValues = PaddingValues())
        }
    }
}