package com.example.androiddevchallenge

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable

@ExperimentalFoundationApi
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PetGrid(pets: List<Pet>) {
    LazyVerticalGrid(cells = GridCells.Fixed(2),
        content = {
            items(pets.size) { index ->
                PetCard(pet = pets[index])
            }
        })
}