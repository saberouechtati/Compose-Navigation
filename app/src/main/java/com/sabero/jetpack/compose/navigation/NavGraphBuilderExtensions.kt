package com.sabero.jetpack.compose.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument


fun NavGraphBuilder.homeScreen(navController: NavHostController) {
    composable(
        route = Screen.Home.route
    ) {
        HomeScreen(navController = navController)
    }
}

fun NavGraphBuilder.detailScreen(navController: NavHostController) {
    composable(
        route = Screen.Detail.route,
        arguments = listOf(
            navArgument(name = REQUIRED_DETAIL_ARGUMENT_KEY_1) {
                type = NavType.IntType
            },
            navArgument(name = REQUIRED_DETAIL_ARGUMENT_KEY_2) {
                type = NavType.StringType
            },
            navArgument(name = OPTIONAL_DETAIL_ARGUMENT_KEY) {
                type = NavType.StringType
                defaultValue = "TUNISIA"
                // nullable = true
            }
        )
    ) {
        val id = it.arguments?.getInt(REQUIRED_DETAIL_ARGUMENT_KEY_1) ?: 0
        val name = it.arguments?.getString(REQUIRED_DETAIL_ARGUMENT_KEY_2) ?: "name"
        val country = it.arguments?.getString(OPTIONAL_DETAIL_ARGUMENT_KEY)
        DetailScreen(navController = navController, id = id, name = name, country = country)
    }
}

