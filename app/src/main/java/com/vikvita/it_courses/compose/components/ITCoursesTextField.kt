package com.vikvita.it_courses.compose.components

import androidx.annotation.DrawableRes
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import com.vikvita.it_courses.compose.base.AppSurface

@Composable
fun ITCoursesTextField(
    modifier: Modifier = Modifier,
    value: String,
    onValueChange: (String) -> Unit,
    @DrawableRes leadingIcon: Int? = null,
    @DrawableRes trailingIcon: Int? = null,
    textStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    placeholder: String?=null,
    colors: TextFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = MaterialTheme.colorScheme.secondary,
        unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
        focusedIndicatorColor = MaterialTheme.colorScheme.secondary,
        unfocusedIndicatorColor = MaterialTheme.colorScheme.secondary,
        focusedPlaceholderColor = MaterialTheme.colorScheme.outline,
        unfocusedPlaceholderColor = MaterialTheme.colorScheme.outline,
        cursorColor = MaterialTheme.colorScheme.onSecondary
    ),

 ) {
        OutlinedTextField(
            modifier= modifier,
            value = value,
            onValueChange = onValueChange,
            shape = MaterialTheme.shapes.extraLarge,
            leadingIcon = leadingIcon?.let {
                {
                    Icon(painter = painterResource(it), contentDescription = null)
                }
            },
            trailingIcon = trailingIcon?.let {
                {
                    Icon(painter = painterResource(it), contentDescription = null)
                }
            },
            placeholder = placeholder?.let {
                {
                    Text(text = placeholder, style = MaterialTheme.typography.bodyMedium)
                }
            },
            colors = colors,
            textStyle = textStyle
        )
}

@Composable
@Preview
private fun ITCoursesTextFieldPreview() {
    var text by remember { mutableStateOf("") }
    AppSurface {
        ITCoursesTextField(
            value = text,
            placeholder = "email@email.com",
            onValueChange = {
                text = it
            }
        )
    }
}