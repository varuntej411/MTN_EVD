package com.mtn.evd.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mtn.evd.R
import com.mtn.evd.model.Country
import com.mtn.evd.navgraph.Screens
import com.mtn.evd.viewmodels.LoginViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountrySelectScreen(navController: NavHostController) {

    val viewModel: LoginViewModel = hiltViewModel()

    val density = LocalDensity.current

    var mTextFieldSize by remember { mutableStateOf(Size.Zero) }

    val isDropDownExpanded = remember {
        mutableStateOf(false)
    }

    val itemPosition = remember {
        mutableStateOf(0)
    }

    val countries = listOf(
        Country("United States", R.drawable.unitedstates),
        Country("Canada", R.drawable.unitedstates),
        Country("India", R.drawable.flag),
        Country("Germany", R.drawable.unitedstates),
        // Add more countries as needed
    )
    val language = listOf("English","Hindi")

    Column(
        modifier = Modifier
            .fillMaxSize().padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        DropdownMenu(
            modifier = Modifier.fillMaxWidth()
                .width(with(density) {
                    mTextFieldSize.width.toDp()
                }),
            expanded = isDropDownExpanded.value,
            onDismissRequest = {
                isDropDownExpanded.value = !isDropDownExpanded.value
            },
            tonalElevation = 20.dp
        ) {
            countries.forEachIndexed { index, username ->
                DropdownMenuItem(
                    modifier = Modifier.fillMaxWidth(),
                    leadingIcon = {
                        Image(
                            modifier = Modifier
                                .width(40.dp)
                                .height(20.dp)
                                .padding(start = 6.dp),
                            painter = painterResource(id = username.flagResId),
                            contentDescription = "flag"
                        )
                    },
                    text = {
                        Text(
                            text = username.name,
                            color = Color.Black,
                            textAlign = TextAlign.Center,
                            fontStyle = FontStyle.Normal,
                            fontFamily = FontFamily.SansSerif,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 16.sp
                        )
                    },
                    onClick = {
                        isDropDownExpanded.value = false
                        itemPosition.value = index
                    }
                )
            }
        }


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .onGloballyPositioned { coordinates ->
                    mTextFieldSize = coordinates.size.toSize()
                }
                .height(50.dp)
                .border(color = Color.Black, width = 1.dp, shape = RoundedCornerShape(25.dp))
                .clickable {
                    isDropDownExpanded.value = true
                },
            horizontalArrangement = Arrangement.spacedBy(6.dp, Alignment.Start),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier
                    .width(40.dp)
                    .height(20.dp)
                    .padding(start = 6.dp),
                painter = painterResource(id = countries[itemPosition.value].flagResId),
                contentDescription = "flag"
            )
            Text(
                text = countries[itemPosition.value].name,
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Normal
                ),
                modifier = Modifier.fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .border(color = Color.Black, width = 1.dp, shape = RoundedCornerShape(25.dp))
                .clickable {
                },
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "English",
                style = TextStyle(
                    color = Color.Black,
                    fontSize = 15.sp,
                    fontFamily = FontFamily.Monospace,
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Normal
                ),
                modifier = Modifier.fillMaxWidth().padding(start = 20.dp)
            )
        }

        Spacer(modifier = Modifier.height(25.dp))

        TextButton(
            onClick = {
                navController.navigate(Screens.LoginScreen.route)
            },
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
                .background(color = Color.Black, shape = RoundedCornerShape(25.dp))
        ) {
            Text(
                text = "Proceed",
                color = Color.White,
                textAlign = TextAlign.Center,
                fontStyle = FontStyle.Normal,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )
        }
    }
}


@Preview
@Composable
fun PreviewProceedScreen() {
    CountrySelectScreen(
        navController = rememberNavController()
    )
}