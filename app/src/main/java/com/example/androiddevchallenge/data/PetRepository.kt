package com.example.androiddevchallenge.data

import android.os.Build
import androidx.annotation.RequiresApi
import java.time.ZoneId
import java.time.ZonedDateTime

class PetRepository  {
    private val pets = listOf(goat, pig, cat, dog, rabbit, hamster, lizard, snake, fish, axolotl, seahorse, horse, chicken, cow)

    // FIX: API data in a world where this is real
    suspend fun getPetList(): List<Pet> {
        return pets
    }

    suspend fun getPetById(id: String?): Pet? {
        return pets.find { it.id == id }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
val goat = Pet(
    "1",
    "Jujube",
    PetCategory.Barnyard,
    PetSpecies.Goat,
    "American Pygmy",
    "https://images.unsplash.com/photo-1533318087102-b3ad366ed041?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=3000&q=80",
    ZonedDateTime.of(2019, 5, 6, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.Female,
    2.0f,
    LongLatLocale(51.05f, 21.41f)
)
@RequiresApi(Build.VERSION_CODES.O)
val pig = Pet(
    "2",
    "Melon",
    PetCategory.Barnyard,
    PetSpecies.Pig,
    "Berkshire",
    "https://images.unsplash.com/photo-1516467508483-a7212febe31a?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2552&q=80",
    ZonedDateTime.of(2017, 2, 2, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.NonBinary,
    2.0f,
    LongLatLocale(-33.17f, 22.23f)
)
@RequiresApi(Build.VERSION_CODES.O)
val dog = Pet(
    "3",
    "Yuzu",
    PetCategory.Dog,
    PetSpecies.Dog,
    "Corgie",
    "https://images.unsplash.com/photo-1588943211346-0908a1fb0b01?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1275&q=80",
    ZonedDateTime.of(2021, 2, 2, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.Male,
    2.0f,
    LongLatLocale(38.9f, -77.0f)
)
@RequiresApi(Build.VERSION_CODES.O)
val rabbit = Pet(
    "4",
    "Carrot",
    PetCategory.SmallAndFurry,
    PetSpecies.Rabbit,
    "Angora\t",
    "https://images.unsplash.com/photo-1535241749838-299277b6305f?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1368&q=80",
    ZonedDateTime.of(2011, 7, 22, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.Female,
    2.0f,
    LongLatLocale(-6.88f, -45.08f)
)
@RequiresApi(Build.VERSION_CODES.O)
val hamster = Pet(
    "5",
    "Mr. Romanescu",
    PetCategory.SmallAndFurry,
    PetSpecies.Hamster,
    "Syrian",
    "https://images.unsplash.com/photo-1599154820236-ebe408351213?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1234&q=80",
    ZonedDateTime.of(2020, 9, 20, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.NonBinary,
    2.0f,
    LongLatLocale(10.785094f, 78.487445f)
)
@RequiresApi(Build.VERSION_CODES.O)
val lizard = Pet(
    "6",
    "Pitaya",
    PetCategory.ScalesAndFins,
    PetSpecies.Lizard,
    "Gecko",
    "https://images.unsplash.com/photo-1586861256632-f273baec5254?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2550&q=80",
    ZonedDateTime.of(2015, 2, 2, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.Female,
    2.0f,
    LongLatLocale(62.326822f, -158.817228f)
)
@RequiresApi(Build.VERSION_CODES.O)
val snake = Pet(
    "7",
    "Lychee",
    PetCategory.ScalesAndFins,
    PetSpecies.Snake,
    "Garter",
    "https://images.unsplash.com/photo-1613176748515-8cd503764873?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2550&q=80",
    ZonedDateTime.of(2013, 7, 1, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.NonBinary,
    2.0f,
    LongLatLocale(34.411734f, -4.129738f)
)
@RequiresApi(Build.VERSION_CODES.O)
val fish = Pet(
    "8",
    "Kumquat",
    PetCategory.ScalesAndFins,
    PetSpecies.Fish,
    "Anthias",
    "https://images.unsplash.com/photo-1524704654690-b56c05c78a00?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2550&q=80",
    ZonedDateTime.of(2020, 8, 14, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.Male,
    2.0f,
    LongLatLocale(43.033020f, 8.350730f)
)
@RequiresApi(Build.VERSION_CODES.O)
val axolotl = Pet(
    "9",
    "Avocado",
    PetCategory.ScalesAndFins,
    PetSpecies.Axolotl,
    "Axolotl",
    "https://images.unsplash.com/photo-1601734242093-757698a2e61b?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1275&q=80",
    ZonedDateTime.of(2021, 1, 1, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.Female,
    2.0f,
    LongLatLocale(-24.891097f, 42.276510f)
)
@RequiresApi(Build.VERSION_CODES.O)
val seahorse = Pet(
    "10",
    "Fennel",
    PetCategory.ScalesAndFins,
    PetSpecies.Seahorse,
    "Zebra",
    "https://images.unsplash.com/photo-1583996862387-042c67de8c49?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2525&q=80",
    ZonedDateTime.of(2017, 12, 12, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.Male,
    2.0f,
    LongLatLocale(20.422198f, -156.180510f)
)
@RequiresApi(Build.VERSION_CODES.O)
val horse = Pet(
    "11",
    "Artichoke",
    PetCategory.Barnyard,
    PetSpecies.Horse,
    "Clydesdale",
    "https://images.unsplash.com/photo-1553284966-19b8815c7817?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2550&q=80",
    ZonedDateTime.of(2013, 12, 5, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.NonBinary,
    2.0f,
    LongLatLocale(41.603386f, -97.469576f)
)
@RequiresApi(Build.VERSION_CODES.O)
val cat = Pet(
    "12",
    "Radish",
    PetCategory.Cat,
    PetSpecies.Cat,
    "Hairless",
    "https://images.unsplash.com/photo-1601280494157-6a5106ad2896?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2550&q=80",
    ZonedDateTime.of(2014, 10, 4, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.Male,
    2.0f,
    LongLatLocale(-31.925444f, 148.923947f)
)
@RequiresApi(Build.VERSION_CODES.O)
val cow = Pet(
    "13",
    "Cauliflower",
    PetCategory.Barnyard,
    PetSpecies.Cow,
    "Gelbvieh",
    "https://images.unsplash.com/photo-1546445317-29f4545e9d53?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1246&q=80",
    ZonedDateTime.of(2010, 11, 12, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.Female,
    2.0f,
    LongLatLocale(20.826630f, -101.212765f)
)
@RequiresApi(Build.VERSION_CODES.O)
val chicken = Pet(
    "14",
    "Popcorn",
    PetCategory.Barnyard,
    PetSpecies.Chicken,
    "Silkie",
    "https://images.unsplash.com/photo-1563281577-a7be47e20db9?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=2550&q=80",
    ZonedDateTime.of(2018, 2, 8, 4, 5, 0, 0, ZoneId.systemDefault()),
    Gender.NonBinary,
    2.0f,
    LongLatLocale(1.613301f, 116.755983f)
)