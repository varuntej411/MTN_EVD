package com.mtn.evd

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mtn.evd.navgraph.HomeNavGraph
import com.mtn.evd.navgraph.Screens
import com.mtn.evd.presentation.components.CustomToolbar
import com.mtn.evd.ui.theme.background

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainHomeNavigationScreen(
    navController: NavHostController = rememberNavController()
) {

    val tabs = listOf(
        R.drawable.baseline_home_24,
        R.drawable.baseline_swap_horiz_24,
        R.drawable.baseline_insert_drive_file_24
    )
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    // Handle back press event
//    BackHandler {
//        if (selectedTabIndex > 0) {
//            // Go back to the previous tab
//            selectedTabIndex -= 1
//        } else {
//            // If on the first tab, exit the app or perform a custom action
//            // For example, you could pop the back stack or exit the app
//            println("Back button pressed on the first tab")
//        }
//    }

    Column(
        modifier = Modifier.fillMaxSize().background(Color.White),
    ) {
        CustomToolbar()

        TabRow(
            modifier = Modifier
                .fillMaxWidth(),
            selectedTabIndex = selectedTabIndex,
            indicator = { tabPositions ->
                // Custom indicator positioning based on selected tab
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex]) // Adjust position to match selected tab
                        .fillMaxWidth()
                        .height(2.dp) // Adjust height of the indicator
                        .background(Color.Black) // Custom color for indicator
                )
            },
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    icon = {
                        Icon(
                            painter = painterResource(tabs[index]),
                            contentDescription = "tab names",
                            tint = if (selectedTabIndex == index) Color.Black else Color.Gray,
                            modifier = Modifier
                                .fillMaxSize()
                                .background(color = background)
                        )
                    },
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                        when (selectedTabIndex) {
                            0 -> navigateToTab(
                                navController = navController,
                                route = Screens.HomeScreen.route
                            )

                            1 -> navigateToTab(
                                navController = navController,
                                route = Screens.TransactionsScreen.route
                            )

                            2 -> navigateToTab(
                                navController = navController,
                                route = Screens.ReportsScreen.route
                            )
                        }
                    }
                )
            }
        }
       HomeNavGraph(navController = navController)
    }
}

@Composable
fun OnBackClickStateSaver(navController: NavHostController) {
    BackHandler(true) {
        navigateToTab(
            navController = navController,
            route = Screens.HomeScreen.route
        )
    }
}

private fun navigateToTab(navController: NavHostController, route: String) {
    navController.navigate(route) {
        navController.graph.startDestinationRoute?.let {
            // popUpTo(it)
            navController.popBackStack(
                route = Screens.MainHomeNavigationScreen.route,
                inclusive = true
            )
        }
        launchSingleTop = true
        restoreState = true
    }
}


@Preview
@Composable
fun MainScreenPreview() {
    MainHomeNavigationScreen()
}