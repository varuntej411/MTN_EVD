package com.mtn.evd.presentation.screens.transactions.subscreens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun TransferScreen(navController: NavHostController, innerPaddingValues: PaddingValues) {

}

@Preview
@Composable
fun PreviewTransactionScreen() {
    TransferScreen(navController = rememberNavController(), innerPaddingValues = PaddingValues())
}