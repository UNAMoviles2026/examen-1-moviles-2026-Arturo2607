package com.moviles.examenmoviles.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNavItem(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object Spaces : BottomNavItem(
        route = AppDestinations.SPACES,
        label = "Spaces",
        icon = Icons.Filled.Home
    )
    object Search : BottomNavItem(
        route = "search",
        label = "Search",
        icon = Icons.Filled.Search
    )
}
