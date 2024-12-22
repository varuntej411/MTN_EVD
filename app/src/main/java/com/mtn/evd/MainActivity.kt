package com.mtn.evd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.mtn.evd.navgraph.SetUpRootNavGraph
import com.mtn.evd.ui.theme.MTNEVDTheme
import com.mtn.evd.ui.theme.background
import com.mtn.evd.viewmodels.SplashViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: SplashViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        //   enableEdgeToEdge()
        splashScreen.setKeepOnScreenCondition {
            viewModel.isSplashShow.value
        }
        setContent {
            MTNEVDTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = background
                ) {
                    SetUpRootNavGraph(navController = navController)
                }
            }
        }
    }
}