package com.mtn.evd.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mtn.evd.MainHomeNavigationScreen

@Composable
fun SetUpRootNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        route = RootNavGraph.ROOT_GRAPH,
        startDestination = RootNavGraph.AUTH_GRAPH
    ) {
        authenticationNavGraph(navController = navController)
        composable(route = RootNavGraph.HOME_GRAPH) {
           MainHomeNavigationScreen()
        }
    }
}

object RootNavGraph {
    const val ROOT_GRAPH = "ROOT_GRAPH"
    const val AUTH_GRAPH = "AUTH_GRAPH"
    const val HOME_GRAPH = "HOME_GRAPH"
}