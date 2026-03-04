package com.zino.todo.components.ui

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun TTextField(
    modifier: Modifier,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    isError: Boolean = false,
    isPassword: Boolean = false,
    singleLine: Boolean = true,
    maxLines: Int = 1,
    label: @Composable (() -> Unit)? = null,
    placeholder: @Composable (() -> Unit)? = null,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    value: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        modifier = modifier,
        enabled = enabled,
        readOnly = readOnly,
        label = label,
        placeholder = placeholder,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon,
        isError = isError,
        keyboardOptions = KeyboardOptions.Default,
        singleLine = singleLine,
        minLines = maxLines,
        visualTransformation = if (isPassword) PasswordVisualTransformation() else VisualTransformation.None,
        maxLines = if (singleLine) 1 else maxLines,
        shape = TextFieldDefaults.shape,
        colors = TextFieldDefaults.colors(
            focusedTextColor = MaterialTheme.colorScheme.onSurface,
            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,

            // Container Colors (Using Surface for a clean look)
            focusedContainerColor = MaterialTheme.colorScheme.surface,
            unfocusedContainerColor = MaterialTheme.colorScheme.surfaceVariant, // Subtle gray

            // The Cursor and Indicator (The "Line" at the bottom)
            cursorColor = MaterialTheme.colorScheme.primary, // Black in Light, White in Dark
            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
            unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary.copy(alpha = 0.5f),

            // Label & Placeholder
            focusedLabelColor = MaterialTheme.colorScheme.onSurface,
            unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,

            // Selection Colors (The highlight when you select text)
            selectionColors = TextSelectionColors(
                handleColor = MaterialTheme.colorScheme.primary,
                backgroundColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
            )
//            focusedTextColor = MaterialTheme.colorScheme.onSurface,
//            unfocusedTextColor = MaterialTheme.colorScheme.onSurface,
//            disabledTextColor = TODO(),
//            errorTextColor = TODO(),
//            focusedContainerColor = TODO(),
//            unfocusedContainerColor = TODO(),
//            disabledContainerColor = TODO(),
//            errorContainerColor = TODO(),
//            cursorColor = TODO(),
//            errorCursorColor = TODO(),
//            textSelectionColors = TODO(),
//            focusedIndicatorColor = TODO(),
//            unfocusedIndicatorColor = TODO(),
//            disabledIndicatorColor = TODO(),
//            errorIndicatorColor = TODO(),
//            focusedLeadingIconColor = TODO(),
//            unfocusedLeadingIconColor = TODO(),
//            disabledLeadingIconColor = TODO(),
//            errorLeadingIconColor = TODO(),
//            focusedTrailingIconColor = TODO(),
//            unfocusedTrailingIconColor = TODO(),
//            disabledTrailingIconColor = TODO(),
//            errorTrailingIconColor = TODO(),
//            focusedLabelColor = TODO(),
//            unfocusedLabelColor = TODO(),
//            disabledLabelColor = TODO(),
//            errorLabelColor = TODO(),
//            focusedPlaceholderColor = TODO(),
//            unfocusedPlaceholderColor = TODO(),
//            disabledPlaceholderColor = TODO(),
//            errorPlaceholderColor = TODO(),
//            focusedSupportingTextColor = TODO(),
//            unfocusedSupportingTextColor = TODO(),
//            disabledSupportingTextColor = TODO(),
//            errorSupportingTextColor = TODO(),
//            focusedPrefixColor = TODO(),
//            unfocusedPrefixColor = TODO(),
//            disabledPrefixColor = TODO(),
//            errorPrefixColor = TODO(),
//            focusedSuffixColor = TODO(),
//            unfocusedSuffixColor = TODO(),
//            disabledSuffixColor = TODO(),
//            errorSuffixColor = TODO(),
        ),
        value = value,
        onValueChange = onValueChange
    )
}