package com.example.androiddevchallenge

sealed class Screen(val route: ScreenRoute) {
    abstract fun getCalculatedRoute(): String

    object PetListScreen: Screen(ScreenRoute.PET_LIST_SCREEN) {
        override fun getCalculatedRoute(): String {
            return route.route
        }
    }

    data class PetDetailsScreen(val petId: String) : Screen(ScreenRoute.PET_DETAILS_SCREEN) {
        override fun getCalculatedRoute(): String {
            return "/details/$petId"
        }
    }
}

enum class ScreenRoute(val route: String) {
    PET_LIST_SCREEN("/list"),
    PET_DETAILS_SCREEN("/details/{petId}")
}