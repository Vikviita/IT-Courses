package com.vikvita.it_courses.features.authorization

import android.content.Intent
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.net.toUri
import com.vikvita.it_courses.R
import com.vikvita.it_courses.compose.base.AppSurface
import com.vikvita.it_courses.compose.components.ITCoursesTextField
import com.vikvita.it_courses.compose.theme.Dimens
import com.vikvita.it_courses.compose.theme.buttonSmall


private val emailRegex = Regex("^[a-z]+@[a-z]+\\.[a-z]{2,}$")
@Composable
fun AuthScreen(
    goToMainScreen: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val activity = LocalActivity.current
    val isSignInButtonEnable by remember{
        derivedStateOf {
            emailRegex.matches(email)&&password.isNotBlank()
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimens.Paddings.m),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.sign_in),
            style = MaterialTheme.typography.headlineLarge
        )
        Spacer(Modifier.height(Dimens.Paddings.xxl))
        Text(
            text = stringResource(R.string.email_title),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(Dimens.Paddings.xs))
        ITCoursesTextField(
            modifier = Modifier.fillMaxWidth(),
            value = email,
            onValueChange = {
                email = it
            },
            placeholder = stringResource(R.string.email_hint),
        )
        Spacer(modifier = Modifier.height(Dimens.Paddings.m))
        Text(
            text = stringResource(R.string.password_title),
            style = MaterialTheme.typography.titleMedium
        )
        Spacer(modifier = Modifier.height(Dimens.Paddings.xs))
        ITCoursesTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = {
                password = it
            },
            placeholder = stringResource(R.string.password_hint),
        )
        Spacer(Modifier.height(Dimens.Paddings.xl))
        Button(modifier = Modifier.fillMaxWidth(), onClick = goToMainScreen, enabled = isSignInButtonEnable) {
            Text(
                text = stringResource(R.string.sign_in),
                style = MaterialTheme.typography.labelLarge
            )
        }
        Spacer(Modifier.height(Dimens.Paddings.m))
        CompositionLocalProvider(LocalTextStyle provides MaterialTheme.typography.buttonSmall) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.no_account) + " ",
                )
                Text(
                    modifier = Modifier.clickable {},
                    text = stringResource(R.string.registration_title),
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable {},
                text = stringResource(R.string.forgot_password),
                color = MaterialTheme.colorScheme.primary
            )
        }
        Spacer(modifier = Modifier.height(Dimens.Paddings.xxxl))
        HorizontalDivider(color = MaterialTheme.colorScheme.surfaceVariant)
        Spacer(modifier = Modifier.height(Dimens.Paddings.xxxl))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(intrinsicSize = IntrinsicSize.Min)
        ) {
            Button(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize(),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2683ED)),
                onClick = {
                    val webpage = "https://vk.com/".toUri()
                    val intent = Intent(Intent.ACTION_VIEW, webpage)
                    activity?.startActivity(intent)
                }
            ) {
                Icon(painter = painterResource(R.drawable.ic_vk), contentDescription = null)
            }
            Spacer(modifier = Modifier.width(Dimens.Paddings.m))
            Surface(
                modifier = Modifier
                    .weight(1f),
                shape = ButtonDefaults.shape,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.linearGradient(
                                start = Offset(0.0f, 20.0f),
                                end = Offset(0.0f, 100.0f),
                                colors = listOf(
                                    Color(0xFFF98509),
                                    Color(0xFFF95D00),
                                ),
                            )
                        )
                        .clickable {
                            val webpage = "https://ok.ru/".toUri()
                            val intent = Intent(Intent.ACTION_VIEW, webpage)
                            activity?.startActivity(intent)
                        },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(painter = painterResource(R.drawable.ic_ok), contentDescription = null)
                }
            }

        }

    }

}


@Composable
@Preview
private fun AuthScreenPreview() {
    AppSurface {
        AuthScreen { }
    }
}