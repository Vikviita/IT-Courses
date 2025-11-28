package com.vikvita.it_courses.features.menu

import com.vikvita.it_courses.R
import com.vikvita.it_courses.features.base.BottomNavItem

val menuBottomNavItemList = listOf<BottomNavItem<MenuRoutes>>(
    BottomNavItem(
        title = R.string.home,
        icon = R.drawable.ic_home,
        destination = MenuRoutes.HomeRoute
    ),
    BottomNavItem(
        title = R.string.favourite,
        icon = R.drawable.ic_favourite,
        destination = MenuRoutes.FavouriteRoute
    ),
    BottomNavItem(
        title = R.string.profile,
        icon = R.drawable.ic_profile,
        destination = MenuRoutes.ProfileRoute
    ),
)