package com.example.androiddevchallenge.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.Period
import java.time.ZonedDateTime

data class Pet(
    val id: String,
    val name: String,
    val category: PetCategory,
    val species: PetSpecies,
    val breed: String,
    val imageUrl: String,
    val dob: ZonedDateTime,
    val gender: Gender,
    val weight: Float,
    val location: String,
    val description: String,
)

enum class PetCategory(val value: String) {
    Dog("dog"),
    Cat("cat"),
    SmallAndFurry("smallFurry"),
    ScalesAndFins("scaleFins"),
    Wings("wings"),
    Horse("horse"),
    Barnyard("barnyard")
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

@RequiresApi(Build.VERSION_CODES.O)
fun ZonedDateTime.age() : String {
    val period = Period.between(this.toLocalDate(), ZonedDateTime.now().toLocalDate())
    if (period.years > 1) {
        return period.years.toString() + " years"
    }
    return period.toTotalMonths().toString() + " months"
}
