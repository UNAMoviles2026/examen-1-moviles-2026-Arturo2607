package com.moviles.examenmoviles.ui.screens.spaces

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.moviles.examenmoviles.data.CoworkingSpace
import com.moviles.examenmoviles.ui.components.AppBottomBar
import com.moviles.examenmoviles.ui.components.SpaceCard
import com.moviles.examenmoviles.ui.theme.ExamenMovilesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpacesScreen(
    onSpaceClick: (Int) -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    val spaces = listOf(
        CoworkingSpace(
            id = 1,
            name = "The Hub",
            description = "A modern open-plan space designed for creative teams and freelancers. Includes high-speed WiFi, standing desks, and a fully equipped kitchen.",
            location = "San José, Barrio Escalante",
            capacity = 20,
            pricePerHour = 8.00,
            isAvailable = true,
            imageUrl = "https://images.unsplash.com/photo-1497366216548-37526070297c?w=800"
        ),
        CoworkingSpace(
            id = 2,
            name = "Nexus Workspace",
            description = "Premium private offices and meeting rooms with panoramic city views. Perfect for focused work and client meetings.",
            location = "San José, Sabana Norte",
            capacity = 10,
            pricePerHour = 15.00,
            isAvailable = true,
            imageUrl = "https://images.unsplash.com/photo-1497366811353-6870744d04b2?w=800"
        ),
        CoworkingSpace(
            id = 3,
            name = "Collab Studio",
            description = "A vibrant community-focused space for startups and entrepreneurs. Regular networking events and mentorship programs available.",
            location = "Heredia, Centro",
            capacity = 35,
            pricePerHour = 6.00,
            isAvailable = false,
            imageUrl = "https://images.unsplash.com/photo-1524758631624-e2822e304c36?w=800"
        ),
        CoworkingSpace(
            id = 4,
            name = "Zen Office",
            description = "Quiet, minimalist environment ideal for deep work. Features noise-cancelling pods, meditation room, and ergonomic furniture.",
            location = "Escazú, San Rafael",
            capacity = 15,
            pricePerHour = 12.00,
            isAvailable = true,
            imageUrl = "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=800"
        ),
        CoworkingSpace(
            id = 5,
            name = "TechNest",
            description = "Tech-focused space with 3D printers, whiteboards, and dual-monitor setups. Ideal for developers and designers.",
            location = "Alajuela, La Guácima",
            capacity = 25,
            pricePerHour = 10.00,
            isAvailable = true,
            imageUrl = "https://images.unsplash.com/photo-1486312338219-ce68d2c6f44d?w=800"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Coworking Spaces") },
                colors = TopAppBarDefaults.topAppBarColors()
            )
        },
        bottomBar = {
            AppBottomBar(navController = navController)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                start = 16.dp,
                end = 16.dp,
                top = innerPadding.calculateTopPadding() + 8.dp,
                bottom = innerPadding.calculateBottomPadding() + 8.dp
            ),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(spaces) { space ->
                SpaceCard(
                    space = space,
                    onClick = { onSpaceClick(space.id) }
                )
            }
        }
    }
}

/*@Preview(showBackground = true, showSystemUi = true, name = "Spaces Screen")
@Composable
fun SpacesScreenPreview() {
    ExamenMovilesTheme {
        SpacesScreen(
            onSpaceClick = {},
            navController = rememberNavController()
        )
    }
}*/