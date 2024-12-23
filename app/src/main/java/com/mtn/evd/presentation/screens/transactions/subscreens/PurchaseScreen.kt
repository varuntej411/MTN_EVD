package com.mtn.evd.presentation.screens.transactions.subscreens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun PurchaseScreen(navController: NavHostController, innerPaddingValues: PaddingValues) {

}

@Preview
@Composable
fun PreviewPurchaseScreen() {
    PurchaseScreen(navController = rememberNavController(), innerPaddingValues = PaddingValues())
}