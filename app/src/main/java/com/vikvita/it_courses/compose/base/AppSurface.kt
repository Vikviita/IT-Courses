package com.vikvita.it_courses.compose.base

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import com.vikvita.it_courses.compose.theme.AppTheme

@Composable
fun AppSurface(content:@Composable ()->Unit){
    AppTheme {
        Surface(color = MaterialTheme.colorScheme.background, content = content)
    }
}