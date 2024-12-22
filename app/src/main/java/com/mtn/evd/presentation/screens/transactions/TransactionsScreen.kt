package com.mtn.evd.presentation.screens.transactions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.mtn.evd.presentation.components.TabView

@Composable
fun TransactionsScreen(navController: NavHostController, innerPaddingValues: PaddingValues) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TabView(innerPadding = innerPaddingValues)
    }
}

@Preview
@Composable
fun PreviewTransactionsScreen() {
    TransactionsScreen(
        navController = NavHostController(LocalContext.current),
        innerPaddingValues = PaddingValues()
    )

}