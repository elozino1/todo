package com.zino.todo.features.auth.signup.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import com.zino.todo.R
import com.zino.todo.components.ui.TText
import com.zino.todo.components.ui.TTextButton
import com.zino.todo.components.ui.TTextField
import com.zino.todo.components.ui.TTextSize
import com.zino.todo.core.designsystem.theme.AppTheme
import com.zino.todo.features.auth.signup.events.SignupEvent
import com.zino.todo.features.auth.signup.viewmodel.SignupViewModel

@Composable
fun SignupScreen(
    modifier: Modifier = Modifier,
    viewModel: SignupViewModel = SignupViewModel()
) {
    val state = viewModel.signupState
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = AppTheme.dimens.screenHorizontalPadding)
                .fillMaxSize()
        ) {
            Image(
                imageVector = ImageVector.vectorResource(id = R.drawable.ic_splash),
                contentDescription = stringResource(R.string.logo_description),
            )
            TText(
                text = stringResource(R.string.create_account_text),
                size = TTextSize.MEDIUM
            )
            Spacer(modifier = Modifier.height(AppTheme.dimens.largeSpace))
            TTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                isError = false,
                label = {
                    TText(
                        text = stringResource(R.string.username_text),
                    )
                },
                placeholder = {
                    TText(
                        text = stringResource(R.string.username_text),
                    )
                },
                value = viewModel.signupState.username,
                onValueChange = {
                    viewModel.onEvent(SignupEvent.UpdateUsername(it))
                }
            )
            Spacer(modifier = Modifier.height(AppTheme.dimens.largeSpace))
            TTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                isError = false,
                label = {
                    TText(
                        text = stringResource(R.string.name_text),
                    )
                },
                placeholder = {
                    TText(
                        text = stringResource(R.string.name_text),
                    )
                },
                value = state.name,
                onValueChange = {
                    viewModel.onEvent(SignupEvent.UpdateName(it))
                }
            )
            Spacer(modifier = Modifier.height(AppTheme.dimens.largeSpace))
            TTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                isError = false,
                label = {
                    TText(
                        text = stringResource(R.string.password_text),
                    )
                },
                placeholder = {
                    TText(
                        text = stringResource(R.string.password_text),
                    )
                },
                value = state.password,
                onValueChange = {
                    viewModel.onEvent(SignupEvent.UpdatePassword(it))
                }
            )
            Spacer(modifier = Modifier.height(AppTheme.dimens.xlargeSpace))
            TTextButton(
                text = stringResource(R.string.create_account_text),
            ) {
                viewModel.onEvent(SignupEvent.Submit)
            }
        }
    }
}