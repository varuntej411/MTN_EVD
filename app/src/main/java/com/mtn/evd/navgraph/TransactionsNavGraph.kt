package com.mtn.evd.navgraph

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mtn.evd.presentation.screens.transactions.subscreens.PurchaseScreen
import com.mtn.evd.presentation.screens.transactions.subscreens.TopUpScreen
import com.mtn.evd.presentation.screens.transactions.subscreens.TransferScreen

@Composable
fun TransactionsNavGraph(navController: NavHostController, innerPaddingValues: PaddingValues) {
    NavHost(
        navController = navController,
        route = RootNavGraph.HOME_GRAPH,
        startDestination = RootNavGraph.TRANSACTIONS_GRAPH
    ) {

        composable(route = Screens.TopUpScreen.route) {
            TopUpScreen(navController = navController, innerPaddingValues = innerPaddingValues)
        }
        composable(route = Screens.TransferScreen.route) {
            TransferScreen(navController = navController, innerPaddingValues = innerPaddingValues)
        }
        composable(route = Screens.PurchaseScreen.route) {
            PurchaseScreen(navController = navController, innerPaddingValues = innerPaddingValues)
        }
    }
}