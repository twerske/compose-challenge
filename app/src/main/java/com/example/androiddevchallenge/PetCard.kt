package com.example.androiddevchallenge

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PetCard(pet: Pet) {
    Card(modifier = Modifier.padding(4.dp)) {
        Column() {
            CoilImage(
                data = pet.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(180.dp),
                fadeIn = true,
            )
            Text(
                pet.name,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                pet.species.toString(),
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}