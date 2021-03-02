package com.example.androiddevchallenge

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.list.PetGrid
import com.example.androiddevchallenge.list.PetListViewModel

@ExperimentalAnimationApi
@ExperimentalFoundationApi
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PetListScreen(navController: NavController, viewModel: PetListViewModel) {
    val pets = viewModel.petsData.observeAsState(emptyMap())
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Text(
                text = stringResource(id = R.string.adoption_title),
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 32.dp
                )
            )
            PetGrid(
                modifier = Modifier.padding(
                    start = 16.dp,
                    end = 16.dp
                ),
                pets.value
            ) {
                pet -> navController.navigate(Screen.PetDetailsScreen(pet.id).getCalculatedRoute())
            }
        }
    }
}