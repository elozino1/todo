package com.zino.todo.features.auth.ui

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import com.zino.todo.R
import com.zino.todo.components.ui.TText
import com.zino.todo.components.ui.TTextButton
import com.zino.todo.components.ui.TTextField
import com.zino.todo.components.ui.TTextSize
import com.zino.todo.core.designsystem.theme.AppTheme

@Composable
fun SignInScreen(
    modifier: Modifier = Modifier
) {
    var username by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    val context = LocalContext.current

    Scaffold { innerPadding ->
        Column (
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = AppTheme.dimens.largeSpace)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_splash),
                contentDescription = stringResource(R.string.logo_description),
            )
            TTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                isError = false,
                label = {
                    TText(
                        text = stringResource(R.string.username_text),
                    )
                },
                value = username,
                onValueChange = {
                    username = it
                }
            )
            Spacer(modifier = Modifier.height(AppTheme.dimens.mediumSpace))
            TTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                isError = false,
                isPassword = true,
                label = {
                    TText(
                        text = stringResource(R.string.password_text),
                    )
                },
                value = password,
                onValueChange = {
                    password = it
                }
            )
            Spacer(modifier = Modifier.height(AppTheme.dimens.xLargeSpace))
            TTextButton(
                text = stringResource(R.string.login_text),
                onClick = { Toast.makeText(context, "Login", Toast.LENGTH_LONG).show() }
            )
            Spacer(modifier = Modifier.height(AppTheme.dimens.largeSpace))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                TText(
                    text = stringResource(R.string.no_account_text)
                )
                Spacer(modifier = Modifier.width(AppTheme.dimens.mediumSpace))
                TText(
                    text = stringResource(R.string.register_text),
                    size = TTextSize.MEDIUM,
                    weight = FontWeight.Bold,
                    decoration = TextDecoration.Underline
                )
            }
        }
    }
}