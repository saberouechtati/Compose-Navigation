package com.sabero.jetpack.compose.navigation

const val HOME_SCREEN = "home_screen"
const val HOME_ROUTE = HOME_SCREEN

const val DETAIL_SCREEN = "detail_screen"
const val REQUIRED_DETAIL_ARGUMENT_KEY_1 = "id"
const val REQUIRED_DETAIL_ARGUMENT_KEY_2 = "name"
const val OPTIONAL_DETAIL_ARGUMENT_KEY = "country"
const val OPTIONAL_DETAIL_ARGUMENT_DEFAULT_VALUE = "Tunisia"
const val DETAIL_ROUTE = "$DETAIL_SCREEN/{$REQUIRED_DETAIL_ARGUMENT_KEY_1}/{$REQUIRED_DETAIL_ARGUMENT_KEY_2}?$OPTIONAL_DETAIL_ARGUMENT_KEY={$OPTIONAL_DETAIL_ARGUMENT_KEY}"

sealed class Screen (val route: String) {
    object Home: Screen(route = HOME_ROUTE)
    object Detail: Screen(route = DETAIL_ROUTE) {
        fun passRequiredIdAndNameAndOptionalCountry(id: Int, name: String, country: String = OPTIONAL_DETAIL_ARGUMENT_DEFAULT_VALUE): String {
            return "$DETAIL_SCREEN/$id/$name?$OPTIONAL_DETAIL_ARGUMENT_KEY=$country"
        }
    }
}


