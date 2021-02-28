package com.example.androiddevchallenge

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@ExperimentalFoundationApi
@OptIn(ExperimentalFoundationApi::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PetGrid(modifier: Modifier, pets: Map<PetCategory, List<Pet>>, onPetClick: (Pet) -> Unit) {
    LazyVerticalGrid(
        modifier = modifier,
        cells = GridCells.Fixed(2),
        content = {
            pets.forEach { (category, pets) ->
                items(pets.size) { index ->
                    PetCard(pet = pets[index], onPetClick = onPetClick)
                }
            }
        }
    )
}