package com.denzel.denotes.ui.theme.common

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val label: String, // label for the item
    val route: String, // route to navigate to
    val icon: ImageVector // icon for the item
)