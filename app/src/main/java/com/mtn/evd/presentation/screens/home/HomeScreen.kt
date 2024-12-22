package com.mtn.evd.presentation.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeScreen(navController: NavHostController, innerPaddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPaddingValues),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text= "hi", modifier = Modifier.fillMaxWidth(), color = Color.Black)
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = rememberNavController(), innerPaddingValues = PaddingValues())
}