package com.moviles.examenmoviles.navigation

object AppDestinations {
    const val SPACES = "spaces"
    const val SPACE_DETAIL = "space_detail/{spaceId}"

    fun spaceDetail(spaceId: Int) = "space_detail/$spaceId"
}
