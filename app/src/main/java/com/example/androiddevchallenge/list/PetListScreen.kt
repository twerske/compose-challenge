package com.example.androiddevchallenge.list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.TextField
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.*
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.TextUnitType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.Screen

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