package com.zino.todo.components.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zino.todo.core.designsystem.theme.AppTheme

@Composable
fun TTextButton(
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        onClick = { onClick() },
        modifier = Modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.textButtonColors(
            containerColor = MaterialTheme.colorScheme.primary,
            contentColor = MaterialTheme.colorScheme.onPrimary
        ),
        contentPadding = PaddingValues(
            vertical = AppTheme.dimens.buttonVerticalPadding,
        ),
        shape = RoundedCornerShape(8.dp)
    ) {
        TText(
            text = text,
            size = TTextSize.MEDIUM,
            color = MaterialTheme.colorScheme.onPrimary
        )
    }
}