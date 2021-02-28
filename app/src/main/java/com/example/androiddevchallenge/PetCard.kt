package com.example.androiddevchallenge

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

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