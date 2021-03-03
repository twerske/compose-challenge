package com.example.androiddevchallenge.details

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Female
import androidx.compose.material.icons.outlined.Male
import androidx.compose.material.icons.outlined.Transgender
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Gender
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.ui.theme.indigo
import com.example.androiddevchallenge.ui.theme.lightBlue
import com.example.androiddevchallenge.ui.theme.neonPink

@Composable
fun GenderIcon(pet: Pet, modifier: Modifier) {
    when (pet.gender) {
        Gender.Male -> {
            Icon(
                Icons.Outlined.Male, "male",
                tint = lightBlue,
                modifier = modifier
                    .size(32.dp)
                    .padding(start = 8.dp, end = 8.dp, top = 0.dp, bottom = 0.dp)
            )
        }
        Gender.Female -> {
            Icon(
                Icons.Outlined.Female, "female",
                tint = lightBlue,
                modifier = modifier
                    .size(32.dp)
                    .padding(start = 8.dp, end = 8.dp, top = 0.dp, bottom = 0.dp)
            )
        }
        else -> {
            Icon(
                Icons.Outlined.Transgender, "transgender",
                tint = lightBlue,
                modifier = modifier
                    .size(32.dp)
                    .padding(start = 8.dp, end = 8.dp, top = 0.dp, bottom = 0.dp)
            )
        }
    }
}