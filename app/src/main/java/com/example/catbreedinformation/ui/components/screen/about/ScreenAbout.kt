package com.example.catbreedinformation.ui.components.screen.about

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign.Companion.Center
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catbreedinformation.R


@Composable
fun ScreenAbout(
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .padding(all = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.my_picture),
            contentDescription = "Creator Picture",
            modifier = modifier
                .size(200.dp)
                .clip(
                    shape = CircleShape
                )
                .border(
                    border = BorderStroke(3.dp, Gray),
                    shape = CircleShape
                )
        )
        Spacer(modifier = modifier.height(16.dp))
        Text(
            text = "Kalfin Syah Kilau Mayya",
            modifier = modifier,
            textAlign  = Center,
            fontWeight = Bold,
            style = TextStyle(
                fontSize = 20.sp
            )
        )
        Spacer(modifier = modifier.height(8.dp))
        Text(
            text = "kalfinsyah.km@gmail.com",
            modifier = modifier,
            textAlign  = Center,
            style = TextStyle(fontSize = 14.sp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenAboutPreview() {
    ScreenAbout(modifier = Modifier)
}