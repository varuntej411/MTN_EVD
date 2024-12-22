package com.mtn.evd.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@SuppressLint("UseOfNonLambdaOffsetOverload")
@Composable
fun SwipeToPayButton(innerPadding: PaddingValues) {

    val context = LocalContext.current
    var swipeCompleted by remember { mutableStateOf(false) }
    var offset by remember { mutableStateOf(0f) }
    val maxOffset = 280f // Maximum distance for the slide (e.g., 300dp)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .padding(16.dp)
    ) {
        // Background track
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(
                    Color.Black,
                    CircleShape
                )
        )

        // Sliding thumb
        Box(
            modifier = Modifier
                .offset(x = offset.dp, y = 0.dp)
                .width(65.dp)
                .padding(start = 2.dp, top = 2.dp, bottom = 2.dp)
                .fillMaxHeight()
                .background(
                    Color.Gray,
                    CircleShape
                ).pointerInput(Unit) {
                    detectHorizontalDragGestures { _, dragAmount ->
                        offset = (offset + dragAmount).coerceIn(
                            0f,
                            maxOffset
                        ) // Restrict the slide within bounds
                    }
                }
        ) {
            Icon(
                Icons.Filled.ArrowForward,
                contentDescription = "Add",
                tint = Color.Black,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }

        // "Pay" button shown when the slider reaches the end
        if (offset == maxOffset) {
            swipeCompleted = true
        } else
            swipeCompleted = false

        // "Slide to Pay" text
        BasicText(
            text = if(!swipeCompleted) "Slide to Transfer" else "",
            style = TextStyle(fontSize = 14.sp, color = Color.White, fontStyle = FontStyle.Normal, fontWeight = FontWeight.Medium, fontFamily = FontFamily.Serif),
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(horizontal = 16.dp)
        )



        // Payment action when swipe is complete
        /*if (swipeCompleted) {
            LaunchedEffect(swipeCompleted) {
                // Simulate the payment action (e.g., API call or processing)
                Toast.makeText(context, "Payment Processed!", Toast.LENGTH_SHORT).show()
                // Optionally reset after a delay
                kotlinx.coroutines.delay(1000)
                swipeCompleted = false
                offsetX = 0f
            }
        }*/
    }
}

@Preview
@Composable
fun PreviewSwipeButton() {
    SwipeToPayButton(innerPadding = PaddingValues())
}