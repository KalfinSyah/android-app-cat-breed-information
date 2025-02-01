package com.example.catbreedinformation.ui.screen.home

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.catbreedinformation.ui.AppViewModelProvider
import com.example.catbreedinformation.ui.components.NoDataFoundInfo
import com.example.catbreedinformation.ui.components.SearchBar

@Composable
fun ScreenHome(
    modifier: Modifier = Modifier,
    viewModel: ScreenHomeViewModel = viewModel(factory = AppViewModelProvider.Factory),
    onClick: (String, Int, String, String, String, String) -> Unit = { _, _, _, _, _, _ -> }
) {
    val context = LocalContext.current
    val catBreeds = viewModel.getCatBreeds(context)


    // this BackHandler will prevent user from exit when user click the back navigation after searching
    // it will delete the query when user click back navigation, then user can click back navigation again for exit
    BackHandler(enabled = viewModel.query.isNotBlank()) {
        viewModel.query = ""
    }

    LazyVerticalGrid(
        modifier = modifier
            .fillMaxSize()
            .testTag("catBreedList"),
        columns = GridCells.Adaptive(minSize = 150.dp),
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        horizontalArrangement = Arrangement.spacedBy((16).dp)
    ) {
        item(span = { GridItemSpan(maxLineSpan) }) {
            SearchBar(
                query = viewModel.query,
                onQueryChange = { viewModel.search(it) },
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
        }
        if (catBreeds.isEmpty()) {
            item(span = { GridItemSpan(maxLineSpan) }) {
                NoDataFoundInfo(modifier = modifier)
            }
        }
        items(catBreeds) { item ->
            HomeScreenItem(
                modifier = modifier,
                name = item.name,
                imageUrl = item.imageUrl,
            ) {
                onClick(
                    item.name,
                    item.imageUrl,
                    item.origin,
                    item.lifespan,
                    item.appearance,
                    item.description
                )
            }
        }
    }
}

@Composable
private fun HomeScreenItem(
    modifier: Modifier = Modifier,
    name: String,
    imageUrl: Int,
    onClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                onClick = { onClick() }
            )
            .testTag("searchResult"),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(imageUrl),
            contentDescription = name,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(160.dp, 200.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(percent = 25),
                    clip = false
                )
                .clip(RoundedCornerShape(percent = 25))
        )
        Spacer(modifier = modifier.height(10.dp))
        Text(
            text = name,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 14.sp,
                shadow = Shadow(
                    color = Color.Gray,
                    offset = Offset(2f, 2f),
                    blurRadius = 16f
                )
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenHomePreview() {
    ScreenHome(
        modifier = Modifier,
    )
}