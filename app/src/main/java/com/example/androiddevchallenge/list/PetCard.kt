package com.example.androiddevchallenge.list

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.data.pig
import com.example.androiddevchallenge.details.GenderIcon
import com.example.androiddevchallenge.ui.theme.outlineColor
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PetCard(pet: Pet, onPetClick: (Pet) -> Unit) {
    Card(
        modifier = Modifier
            .padding(start = 4.dp, end = 4.dp, top = 4.dp, bottom = 8.dp)
            .clip(MaterialTheme.shapes.medium)
            .clickable { onPetClick(pet) },
        elevation = 8.dp,
        border = BorderStroke(4.dp, MaterialTheme.colors.outlineColor),
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Column {
            CoilImage(
                data = pet.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(180.dp)
                    .clip(MaterialTheme.shapes.medium)
                    .border(BorderStroke(4.dp, MaterialTheme.colors.primaryVariant)),
                fadeIn = true,
            )
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween){
                Text(
                    pet.name,
                    style = MaterialTheme.typography.h4,
                    modifier = Modifier.padding(start = 8.dp, end = 8.dp, top = 4.dp)
                )
                GenderIcon(pet = pet, modifier = Modifier)
            }
            Text(
                pet.breed + " " + pet.species,
                color = MaterialTheme.colors.onPrimary,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 2.dp, bottom = 8.dp)
            )
        }
    }
}

@Preview
@Composable
fun PetPreview(){
    PetCard(pet = pig, onPetClick = {  })
}