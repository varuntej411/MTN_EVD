package com.mtn.evd.navgraph

sealed class Screens (val route: String){
    data object SplashScreen : Screens(route = "SplashScreen")
    data object CountrySelectScreen : Screens(route = "CountrySelectScreen")
    data object LoginScreen : Screens(route = "LoginScreen")
    data object OnBoardingScreen : Screens(route = "OnBoardingScreen")
    data object MainHomeNavigationScreen : Screens(route = "MainHomeNavScreen")
    data object HomeScreen : Screens(route = "HomeScreen")
    data object TransactionsScreen : Screens(route = "TransactionsScreen")
    data object ReportsScreen : Screens(route = "ReportsScreen")
    data object TopUpScreen : Screens(route = "TopUpScreen")
    data object TransferScreen : Screens(route = "TransferScreen")
    data object PurchaseScreen : Screens(route = "PurchaseScreen")
}