package com.vikvita.it_courses.features.base

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class BottomNavItem<T>(
    @StringRes val title: Int,
    @DrawableRes val icon: Int,
    val destination: T
)