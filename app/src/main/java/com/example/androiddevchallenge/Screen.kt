package com.example.androiddevchallenge

sealed class Screen(val route: String) {
    object PetListScreen: Screen("/list")
    object PetDetailsScreen: Screen("/details")
}