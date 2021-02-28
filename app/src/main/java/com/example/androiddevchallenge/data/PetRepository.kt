package com.example.androiddevchallenge.data

import com.example.androiddevchallenge.*
import java.time.ZoneId
import java.time.ZonedDateTime

class PetRepository  {
    private val pets = listOf(goat, pig, cat, dog)

    // FIX: API data in a world where this is real
    suspend fun getPetList(): List<Pet> {
        return pets
    }

    suspend fun getPetById(id: String?): Pet? {
        return pets.find { it.id == id }
    }
}

val goat = Pet(
    "1",
    "Fred",
    PetCategory.Barnyard,
    PetSpecies.Goat,
    "",
    "https://picsum.photos/300/300",
    ZonedDateTime.of(2012, 2, 2, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.NonBinary,
    2.0f,
    LongLatLocale(25.3f, 23.12f)
)
val pig = Pet(
    "2",
    "Fred",
    PetCategory.Barnyard,
    PetSpecies.Pig,
    "",
    "https://picsum.photos/300/300",
    ZonedDateTime.of(2012, 2, 2, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.NonBinary,
    2.0f,
    LongLatLocale(25.3f, 23.12f)
)
val dog = Pet(
    "3",
    "Doggie",
    PetCategory.Dog,
    PetSpecies.Dog,
    "",
    "https://picsum.photos/300/300",
    ZonedDateTime.of(2012, 2, 2, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.NonBinary,
    2.0f,
    LongLatLocale(25.3f, 23.12f)
)
val cat = Pet(
    "4",
    "Kittie",
    PetCategory.Cat,
    PetSpecies.Cat,
    "",
    "https://picsum.photos/300/300",
    ZonedDateTime.of(2012, 2, 2, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.NonBinary,
    2.0f,
    LongLatLocale(25.3f, 23.12f)
)