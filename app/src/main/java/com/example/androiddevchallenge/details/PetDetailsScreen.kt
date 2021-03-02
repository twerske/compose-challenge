package com.example.androiddevchallenge

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.details.PetDetailsViewModel
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun PetDetailsScreen(navController: NavController, petId: String?, viewModel: PetDetailsViewModel) {
    viewModel.loadPetInfo(petId = petId)

    val pet = viewModel.petData.observeAsState()
    if (pet.value != null) {
        val pet = pet.value!!
        Column {
            CoilImage(
                data = pet.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(360.dp),
                fadeIn = true,
            )
            Text(
                pet.name,
                style = MaterialTheme.typography.h5,
                modifier = Modifier.padding(8.dp)
            )
            Text(
                pet.species.toString(),
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(8.dp)
            )
        }
    } else {
        CircularProgressIndicator()
    }
}