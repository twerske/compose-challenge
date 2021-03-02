package com.example.androiddevchallenge.data

import java.time.ZonedDateTime

data class Pet(
    val id: String,
    val name: String,
    val category: PetCategory,
    val species: PetSpecies,
    val breed: String?,
    val imageUrl: String,
    val dob: ZonedDateTime,
    val gender: Gender,
    val weight: Float,
    val location: LongLatLocale,
)

enum class PetCategory {
    Dog,
    Cat,
    SmallAndFurry,
    ScalesAndFins,
    Wings,
    Horse,
    Barnyard
}

enum class PetSpecies {
    Dog,
    Cat,
    Rabbit,
    Hamster,
    Lizard,
    Snake,
    Fish,
    Axolotl,
    Seahorse,
    Horse,
    Chicken,
    Goat,
    Cow,
    Pig
}

enum class Gender {
    Female,
    Male,
    NonBinary,
}

data class LongLatLocale(
    val longitude: Float,
    val latitude: Float
)
