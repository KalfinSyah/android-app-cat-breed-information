package com.example.catbreedinformation.ui.screen.detail

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.catbreedinformation.R

@Composable
fun ScreenDetail(
    modifier: Modifier = Modifier,
    name: String,
    imageUrl: Int,
    origin: String,
    lifespan: String,
    appearance: String,
    description: String,
    onBackButtonClicked: () -> Unit = {},
    onFavoriteButtonClicked: (Boolean) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        DetailScreenItem(
            modifier = modifier,
            name = name,
            imageUrl = imageUrl,
            origin = origin,
            lifespan = lifespan,
            appearance = appearance,
            description = description,
            onBackButtonClicked = onBackButtonClicked,
            onFavoriteButtonClicked = onFavoriteButtonClicked,
        )
    }
}

@Composable
fun DetailScreenItem(
    modifier: Modifier = Modifier,
    name: String,
    imageUrl: Int,
    origin: String,
    lifespan: String,
    appearance: String,
    description: String,
    onBackButtonClicked: () -> Unit = {},
    onFavoriteButtonClicked: (Boolean) -> Unit = {}
) {

    Button(
        onClick = { onBackButtonClicked() },
        modifier = modifier,
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        )
    ) {
        Text(
            text = "Back",
            style = TextStyle(
                color = Color.White,
            )
        )
    }
    Spacer(modifier = modifier.height(32.dp))
    Box(modifier = modifier) {
        var isFavorited by rememberSaveable { mutableStateOf(false) }
        Image(
            painter = painterResource(imageUrl),
            contentDescription = name,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .size(300.dp, 450.dp)
                .shadow(
                    elevation = 8.dp,
                    shape = RoundedCornerShape(percent = 25),
                    clip = false
                )
                .clip(RoundedCornerShape(percent = 25))
        )
        Icon(
            imageVector = if (isFavorited) {
                Icons.Default.Favorite
            } else {
                Icons.Default.FavoriteBorder
            },
            contentDescription = "Favorite",
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(20.dp)
                .size(50.dp)
                .padding(4.dp)
                .clickable {
                    isFavorited = !isFavorited
                    onFavoriteButtonClicked(isFavorited)
                },
            tint = Color.Red
        )
    }

    Spacer(modifier = modifier.height(32.dp))
    ScreenDetailSubItem(
        modifierSurface = modifier,
        modifierText = modifier,
        text = name
    )
    Spacer(modifier = modifier.height(24.dp))
    ScreenDetailSubItem(
        modifierSurface = modifier,
        modifierText = modifier,
        text = LocalContext.current.getString(
            R.string.label_origin,
            origin
        )
    )
    Spacer(modifier = modifier.height(24.dp))
    ScreenDetailSubItem(
        modifierSurface = modifier,
        modifierText = modifier,
        text = LocalContext.current.getString(
            R.string.label_life_span,
            lifespan
        )
    )
    Spacer(modifier = modifier.height(24.dp))
    ScreenDetailSubItem(
        modifierSurface = modifier,
        modifierText = modifier,
        text = LocalContext.current.getString(
            R.string.label_appearance,
            appearance
        )
    )
    Spacer(modifier = modifier.height(40.dp))
    ScreenDetailSubItem(
        modifierSurface = modifier,
        modifierText = modifier.padding(32.dp),
        text = description,
        textAlignText = TextAlign.Justify
    )
}

@Composable
fun ScreenDetailSubItem(
    @SuppressLint("ModifierParameter")
    modifierSurface: Modifier,
    shapeSurface: RoundedCornerShape = RoundedCornerShape(25),
    colorSurface: Color = Color.White,
    contentColorSurface: Color = contentColorFor(colorSurface),
    tonalElevationSurface: Dp = 0.dp,
    shadowElevationSurface: Dp = 0.dp,
    borderSurface: BorderStroke? = null,
    text: String,
    modifierText: Modifier,
    colorText: Color = Color.Unspecified,
    fontSizeText: TextUnit = TextUnit.Unspecified,
    fontStyleText: FontStyle? = null,
    fontWeightText: FontWeight? = FontWeight.Normal,
    fontFamilyText: FontFamily? = null,
    letterSpacingText: TextUnit = TextUnit.Unspecified,
    textDecorationText: TextDecoration? = null,
    textAlignText: TextAlign? = TextAlign.Center,
    lineHeightText: TextUnit = TextUnit.Unspecified,
    overflowText: TextOverflow = TextOverflow.Clip,
    softWrapText: Boolean = true,
    maxLinesText: Int = Int.MAX_VALUE,
    minLinesText: Int = 1,
    onTextLayoutText: ((TextLayoutResult) -> Unit)? = null,
    styleText: TextStyle = TextStyle(
        fontSize = 20.sp,
        color = Color.Black,
    )
) {
    Surface(
        modifier = modifierSurface
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(percent = 25),
                clip = false
            ),
        shape = shapeSurface,
        color = colorSurface,
        contentColor = contentColorSurface,
        tonalElevation = tonalElevationSurface,
        shadowElevation = shadowElevationSurface,
        border = borderSurface,
    ) {
        Text(
            text = text,
            modifier = modifierText
                .padding(16.dp),
            color = colorText,
            fontSize = fontSizeText,
            fontStyle = fontStyleText,
            fontWeight = fontWeightText,
            fontFamily = fontFamilyText,
            letterSpacing = letterSpacingText,
            textDecoration = textDecorationText,
            textAlign = textAlignText,
            lineHeight = lineHeightText,
            overflow = overflowText,
            softWrap = softWrapText,
            maxLines = maxLinesText,
            minLines = minLinesText,
            onTextLayout = onTextLayoutText,
            style = styleText
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ScreenDetailPreview() {
    ScreenDetail(
        modifier = Modifier,
        name = "Abyssinian",
        imageUrl = R.drawable.abyssinian,
        origin = "Ethiopia",
        lifespan = "9–15 years",
        appearance = "Medium-sized, slender, and muscular body with a ticked coat.",
        description = "The Abyssinian is one of the oldest known cat breeds, believed to have originated in ancient Egypt. These cats are highly active, curious, and intelligent. Their love for climbing makes them enjoy high places like bookshelves or cat trees. They are affectionate with their owners but can also be independent. Abyssinians thrive in environments where they have plenty of mental stimulation and opportunities to play. Their unique ticked coat comes in a variety of shades, often giving them a wild, exotic appearance.",
    )
}