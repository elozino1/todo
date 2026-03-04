package com.zino.todo.components.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

@Composable
fun TText(
    text: String,
    size: TTextSize = TTextSize.SMALL,
    color: Color = MaterialTheme.colorScheme.primary,
    weight: FontWeight = FontWeight.Normal,
    decoration: TextDecoration = TextDecoration.None
) {
    Text(
        color = color,
        text = text,
        fontSize = getTextSize(size),
        fontWeight = weight,
        textDecoration = decoration
    )
}

fun getTextSize(size: TTextSize) : TextUnit {
    return when(size) {
        TTextSize.XXSMALL -> 10.sp
        TTextSize.XSMALL -> 12.sp
        TTextSize.SMALL -> 14.sp
        TTextSize.MEDIUM -> 16.sp
        TTextSize.LARGE -> 28.sp
        TTextSize.XLARGE -> 20.sp
        TTextSize.XXLARGE -> 22.sp
    }
}

enum class TTextSize {
    XXSMALL,
    XSMALL,
    SMALL,
    MEDIUM,
    LARGE,
    XLARGE,
    XXLARGE
}