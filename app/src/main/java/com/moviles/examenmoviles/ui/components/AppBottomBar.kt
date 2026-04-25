package com.moviles.examenmoviles.ui.components

import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.moviles.examenmoviles.navigation.AppDestinations
import com.moviles.examenmoviles.navigation.BottomNavItem

@Composable
fun AppBottomBar(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val items = listOf(BottomNavItem.Spaces, BottomNavItem.Search)
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    // Determine the selected item: detail screen highlights Spaces tab
    val selectedRoute = when {
        currentRoute?.startsWith("space_detail") == true -> AppDestinations.SPACES
        else -> currentRoute
    }

    NavigationBar(modifier = modifier) {
        items.forEach { item ->
            NavigationBarItem(
                selected = selectedRoute == item.route,
                onClick = {
                    if (item.route != selectedRoute) {
                        navController.navigate(item.route) {
                            popUpTo(AppDestinations.SPACES) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    Icon(imageVector = item.icon, contentDescription = item.label)
                },
                label = { Text(text = item.label) }
            )
        }
    }
}
