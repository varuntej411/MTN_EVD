package com.mtn.evd.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
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
import com.mtn.evd.ui.theme.MTNEVDTheme
import com.mtn.evd.ui.theme.background

@Composable
fun TabView(innerPadding: PaddingValues) {
    val tabs = listOf("TopUp", "Transfer", "Purchase")
    var selectedTabIndex by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding),
        verticalArrangement = Arrangement.SpaceAround,
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
                            text = title,
                            style = TextStyle(
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Black,
                                fontFamily = FontFamily.Monospace,
                                fontStyle = FontStyle.Normal
                            ),
                            maxLines = 1
                        )
                    },
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index }
                )
            }
        }

        // Display content based on selected tab
        when (selectedTabIndex) {
            0 -> TabContent("This is Tab 1 content")
            1 -> TabContent("This is Tab 2 content")
            2 -> TabContent("This is Tab 3 content")
        }
    }
}

@Composable
fun TabContent(content: String) {
    Text(
        text = content,
        fontSize = 24.sp,
        modifier = Modifier.fillMaxSize()
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MTNEVDTheme {
        TabView(innerPadding = PaddingValues())
    }
}