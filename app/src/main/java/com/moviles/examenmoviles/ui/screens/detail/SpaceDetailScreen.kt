package com.moviles.examenmoviles.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.People
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.moviles.examenmoviles.data.CoworkingSpace
import com.moviles.examenmoviles.ui.components.AppBottomBar
import com.moviles.examenmoviles.ui.components.AppButton
import com.moviles.examenmoviles.ui.components.AvailabilityBadge
import com.moviles.examenmoviles.ui.components.InfoRow
import com.moviles.examenmoviles.ui.theme.ExamenMovilesTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SpaceDetailScreen(
    space: CoworkingSpace,
    onBackClick: () -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = space.name) },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Go back"
                        )
                    }
                }
            )
        },
        bottomBar = {
            AppBottomBar(navController = navController)
        }
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            AsyncImage(
                model = space.imageUrl,
                contentDescription = "Image of ${space.name}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = space.name,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
                AvailabilityBadge(isAvailable = space.isAvailable)

                Spacer(modifier = Modifier.height(4.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "About this space",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                Text(
                    text = space.description,
                    style = MaterialTheme.typography.bodyMedium
                )

                Spacer(modifier = Modifier.height(4.dp))
                HorizontalDivider()
                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = "Details",
                    style = MaterialTheme.typography.titleSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                InfoRow(
                    icon = Icons.Filled.LocationOn,
                    label = "Location",
                    value = space.location
                )
                InfoRow(
                    icon = Icons.Filled.People,
                    label = "Capacity",
                    value = "${space.capacity} people"
                )
                InfoRow(
                    icon = Icons.Filled.AttachMoney,
                    label = "Price",
                    value = "$${space.pricePerHour} per hour"
                )

                Spacer(modifier = Modifier.height(8.dp))

                AppButton(
                    text = if (space.isAvailable) "Reserve This Space" else "Currently Unavailable",
                    onClick = { /* Reservation logic – out of PoC scope */ },
                    enabled = space.isAvailable
                )
            }
        }
    }
}

/*@Preview(showBackground = true, showSystemUi = true, name = "Detail - Available")
@Composable
fun SpaceDetailScreenPreviewAvailable() {
    ExamenMovilesTheme {
        SpaceDetailScreen(
            space = CoworkingSpace(
                id = 1,
                name = "The Hub",
                description = "A modern open-plan space designed for creative teams and freelancers. Includes high-speed WiFi, standing desks, and a fully equipped kitchen.",
                location = "San José, Barrio Escalante",
                capacity = 20,
                pricePerHour = 8.00,
                isAvailable = true,
                imageUrl = ""
            ),
            onBackClick = {},
            navController = rememberNavController()
        )
    }
}*/

/*@Preview(showBackground = true, showSystemUi = true, name = "Detail - Unavailable")
@Composable
fun SpaceDetailScreenPreviewUnavailable() {
    ExamenMovilesTheme {
        SpaceDetailScreen(
            space = CoworkingSpace(
                id = 3,
                name = "Collab Studio",
                description = "A vibrant community-focused space for startups and entrepreneurs. Regular networking events and mentorship programs available.",
                location = "Heredia, Centro",
                capacity = 35,
                pricePerHour = 6.00,
                isAvailable = false,
                imageUrl = ""
            ),
            onBackClick = {},
            navController = rememberNavController()
        )
    }
}*/