package com.moviles.examenmoviles.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.moviles.examenmoviles.data.CoworkingSpace
import com.moviles.examenmoviles.ui.screens.detail.SpaceDetailScreen
import com.moviles.examenmoviles.ui.screens.spaces.SpacesScreen

@Composable
fun AppNavHost(innerPadding: PaddingValues) {
    val navController = rememberNavController()

    // Shared mock data – single source of truth to look up spaces on detail screen
    val spaces = listOf(
        CoworkingSpace(id = 1, name = "The Hub", description = "A modern open-plan space designed for creative teams and freelancers. Includes high-speed WiFi, standing desks, and a fully equipped kitchen.", location = "San José, Barrio Escalante", capacity = 20, pricePerHour = 8.00, isAvailable = true, imageUrl = "https://images.unsplash.com/photo-1497366216548-37526070297c?w=800"),
        CoworkingSpace(id = 2, name = "Nexus Workspace", description = "Premium private offices and meeting rooms with panoramic city views. Perfect for focused work and client meetings.", location = "San José, Sabana Norte", capacity = 10, pricePerHour = 15.00, isAvailable = true, imageUrl = "https://images.unsplash.com/photo-1497366811353-6870744d04b2?w=800"),
        CoworkingSpace(id = 3, name = "Collab Studio", description = "A vibrant community-focused space for startups and entrepreneurs. Regular networking events and mentorship programs available.", location = "Heredia, Centro", capacity = 35, pricePerHour = 6.00, isAvailable = false, imageUrl = "https://images.unsplash.com/photo-1524758631624-e2822e304c36?w=800"),
        CoworkingSpace(id = 4, name = "Zen Office", description = "Quiet, minimalist environment ideal for deep work. Features noise-cancelling pods, meditation room, and ergonomic furniture.", location = "Escazú, San Rafael", capacity = 15, pricePerHour = 12.00, isAvailable = true, imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=800"),
        CoworkingSpace(id = 5, name = "TechNest", description = "Tech-focused space with 3D printers, whiteboards, and dual-monitor setups. Ideal for developers and designers.", location = "Alajuela, La Guácima", capacity = 25, pricePerHour = 10.00, isAvailable = true, imageUrl = "https://images.unsplash.com/photo-1486312338219-ce68d2c6f44d?w=800")
    )

    NavHost(
        navController = navController,
        startDestination = AppDestinations.SPACES,
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
    ) {
        composable(route = AppDestinations.SPACES) {
            SpacesScreen(
                onSpaceClick = { spaceId ->
                    navController.navigate(AppDestinations.spaceDetail(spaceId))
                },
                navController = navController
            )
        }

        composable(
            route = AppDestinations.SPACE_DETAIL,
            arguments = listOf(navArgument("spaceId") { type = NavType.IntType })
        ) { backStackEntry ->
            val spaceId = backStackEntry.arguments?.getInt("spaceId") ?: return@composable
            val space = spaces.find { it.id == spaceId } ?: return@composable
            SpaceDetailScreen(
                space = space,
                onBackClick = { navController.popBackStack() },
                navController = navController
            )
        }
    }
}
