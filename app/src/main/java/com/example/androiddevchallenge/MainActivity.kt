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
package com.example.androiddevchallenge

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.ui.theme.MyTheme
import java.time.ZoneId
import java.time.ZonedDateTime

class MainActivity : AppCompatActivity() {

    val viewModel by viewModels<AdoptViewModel>()

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(viewModel = viewModel)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
class AdoptViewModel : ViewModel() {
    private val _animalsData = MutableLiveData<List<Pet>>()
    val petsData: LiveData<List<Pet>>
        get() = _animalsData

    init {
        // FIXUP: API data in a world where this is real
        val goat = Pet(
            "1",
            "Fred",
            PetCategory.Barnyard,
            PetSpecies.Goat,
            "",
            "https://images.unsplash.com/photo-2jXkA7GAz9M",
            ZonedDateTime.of(2012, 2, 2, 4, 5, 0, 0, ZoneId.systemDefault()),
            Gender.NonBinary,
            2.0f,
            LongLatLocale(25.3f, 23.12f)
        )
        val pig = Pet(
            "1",
            "Fred",
            PetCategory.Barnyard,
            PetSpecies.Pig,
            "",
            "https://images.unsplash.com/photo-ZKbve9f7Mp4",
            ZonedDateTime.of(2012, 2, 2, 4, 5, 0, 0, ZoneId.systemDefault()),
            Gender.NonBinary,
            2.0f,
            LongLatLocale(25.3f, 23.12f)
        )

        _animalsData.value = listOf(goat, pig)
    }
}

// Start building your app here!
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyApp(viewModel: AdoptViewModel = AdoptViewModel()) {
    val pets = viewModel.petsData.observeAsState(emptyList())
    Surface(color = MaterialTheme.colors.background) {
        LazyVerticalGrid(cells = GridCells.Fixed(2),
            content = {
                items(pets.value.size) { index ->
                    PetCard(pet = pets.value[index])
                }
            })
    }
}

@Composable
fun PetCard(pet: Pet) {
    Card(modifier = Modifier.padding(4.dp)) {
        Column() {
            Text(
                pet.name,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                pet.species.toString(),
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}

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




