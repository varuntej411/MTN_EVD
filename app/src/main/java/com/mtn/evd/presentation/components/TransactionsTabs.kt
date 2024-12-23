package com.mtn.evd.presentation.components

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mtn.evd.navgraph.Screens
import com.mtn.evd.ui.theme.MTNEVDTheme
import com.mtn.evd.ui.theme.background

@Composable
fun TransactionsTabs(navController: NavHostController, innerPadding: PaddingValues) {
    val tabs = listOf("TopUp", "Transfer", "Purchase")
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(innerPadding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TabRow(
            modifier = Modifier.fillMaxWidth(),
            selectedTabIndex = selectedTabIndex,
            containerColor = background,
            indicator = { tabPositions ->
                // Optionally, you can customize the indicator appearance here
                Box(
                    modifier = Modifier
                        .tabIndicatorOffset(tabPositions[selectedTabIndex]) // Adjust position to match selected tab
                        .fillMaxWidth()
                        .height(2.dp) // Adjust height of the indicator
                        .background(Color.Black) // Custom color for indicator
                )
            }
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = {
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = title,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black,
                                fontFamily = FontFamily.Monospace,
                                fontStyle = FontStyle.Normal
                            ),
                            maxLines = 1,
                            color = if (selectedTabIndex == index) Color.Black else Color.Gray
                        )
                    },
                    selected = selectedTabIndex == index,
                    onClick = {
                        selectedTabIndex = index
                        when (selectedTabIndex) {
                            0 -> navigateToTab(
                                navController = navController,
                                route = Screens.TopUpScreen.route
                            )

                            1 -> navigateToTab(
                                navController = navController,
                                route = Screens.TransferScreen.route
                            )

                            2 -> navigateToTab(
                                navController = navController,
                                route = Screens.PurchaseScreen.route
                            )
                        }
                    }
                )
            }
        }
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
                route = Screens.TransactionsScreen.route,
                inclusive = true
            )
        }
        launchSingleTop = true
        restoreState = true
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MTNEVDTheme {
        TransactionsTabs(navController = rememberNavController(), innerPadding = PaddingValues())
    }
}