package com.vikvita.it_courses.compose.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.toFontFamily
import com.vikvita.it_courses.R

private val roboto_regular = Font(R.font.roboto_regular).toFontFamily()
private val roboto_medium = Font(R.font.roboto_medium).toFontFamily()
private val roboto_bold = Font(R.font.roboto_bold).toFontFamily()



val AppTypography = Typography(
    bodyMedium = TextStyle(fontFamily = roboto_regular),
    titleMedium = TextStyle(fontFamily = roboto_medium, fontSize = Dimens.TextSize.m),
    bodySmall = TextStyle(fontFamily = roboto_regular),
    headlineLarge = TextStyle(fontFamily = roboto_regular, fontSize = Dimens.TextSize.xl),
    labelLarge = TextStyle(fontFamily = roboto_medium)
)

val Typography.buttonSmall:TextStyle
    get() = TextStyle(fontFamily = roboto_bold, fontSize = Dimens.TextSize.xs)

val Typography.caption:TextStyle
   get()= TextStyle(fontFamily = roboto_regular, fontSize = Dimens.TextSize.xs)

