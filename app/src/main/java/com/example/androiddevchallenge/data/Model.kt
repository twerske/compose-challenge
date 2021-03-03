/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
fun ZonedDateTime.age(): String {
    val period = Period.between(this.toLocalDate(), ZonedDateTime.now().toLocalDate())
    if (period.years > 1) {
        return period.years.toString() + " years"
    }
    return period.toTotalMonths().toString() + " months"
}
