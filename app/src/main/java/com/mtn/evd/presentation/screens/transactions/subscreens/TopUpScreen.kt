package com.mtn.evd.presentation.screens.transactions.subscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mtn.evd.ui.theme.background

@Composable
fun TopUpScreen(navController: NavHostController, innerPaddingValues: PaddingValues) {
    var selectedReseller by remember {
        mutableStateOf(false)
    }

    var selectedMSISDN by remember {
        mutableStateOf(true)
    }

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    ) {
        Row(
            modifier = Modifier.padding(top = 10.dp)
                .width(IntrinsicSize.Min)
                .height(35.dp)
                .padding(horizontal = 10.dp)
                .background(color = Color.LightGray, shape = RoundedCornerShape(18.dp)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            TextButton(
                onClick = {
                    selectedReseller = !selectedReseller
                    selectedMSISDN = !selectedMSISDN
                },
                modifier = Modifier
                    .background(
                        color = if (selectedReseller) background else Color.LightGray,
                        shape = RoundedCornerShape(bottomStart = 10.dp, topStart = 10.dp)
                    )
                    .padding(horizontal = 5.dp)
            ) {
                Text(
                    text = "Prepaid",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.labelSmall
                )
            }

            TextButton(
                onClick = {
                    selectedMSISDN = !selectedMSISDN
                    selectedReseller = !selectedReseller
                },
                modifier = Modifier
                    .background(
                        color = if (selectedMSISDN) background else Color.LightGray,
                        shape = RoundedCornerShape(topEnd = 10.dp, bottomEnd = 10.dp)
                    )
                    .padding(horizontal = 5.dp),
            ) {
                Text(
                    text = "Postpaid",
                    color = Color.Black,
                    textAlign = TextAlign.Center,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    style = MaterialTheme.typography.labelSmall
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewTopUpScreen() {
    TopUpScreen(navController = rememberNavController(), innerPaddingValues = PaddingValues())
}