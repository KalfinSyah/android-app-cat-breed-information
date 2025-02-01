package com.example.catbreedinformation.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextLayoutResult
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SurfaceAndTextFusion(
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
    ),
    testTag: String = ""
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
                .padding(16.dp)
                .testTag(testTag),
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
            style = styleText,
        )
    }
}