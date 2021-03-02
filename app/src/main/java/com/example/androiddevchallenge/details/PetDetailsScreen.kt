package com.example.androiddevchallenge.details

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.outlined.Place
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.data.age
import com.example.androiddevchallenge.data.pig
import com.example.androiddevchallenge.ui.theme.outlineColor
import com.example.androiddevchallenge.ui.theme.purple200
import com.example.androiddevchallenge.ui.theme.teal200
import dev.chrisbanes.accompanist.coil.CoilImage

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PetDetailsScreen(navController: NavController, petId: String?, viewModel: PetDetailsViewModel) {
    viewModel.loadPetInfo(petId = petId)

    Surface(color = MaterialTheme.colors.background) {
        val pet = viewModel.petData.observeAsState()
        if (pet.value != null) {
            val pet = pet.value!!

            Column {
                PetDetails(pet = pet, onBackPress = { navController.popBackStack() })
            }
        } else {
            CircularProgressIndicator()
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun PetDetailsPreview(){
    PetDetails(pet = pig, onBackPress = {  })
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun PetDetails(pet: Pet, onBackPress : () -> Unit){
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
    ) {
        CoilImage(
            data = pet.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(350.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = CornerSize(0.dp),
                        topEnd = CornerSize(0.dp),
                        bottomEnd = CornerSize(32.dp),
                        bottomStart = CornerSize(32.dp)
                    )
                )
        )
        PetCardInformation(pet = pet)
        Row(modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween){
            Text(text = pet.name,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 0.dp)
            )
            Text(text = pet.breed + " " + pet.species,
                style = MaterialTheme.typography.h6,
                modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 0.dp),
                textAlign = TextAlign.End
            )
        }
        Location(pet = pet)
        AboutSection(pet = pet)
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom) {
        AdoptButtonBar()
    }
}

@Composable
fun AboutSection(pet: Pet){
    Text(text = stringResource(id = R.string.about_pet_heading),
        style = MaterialTheme.typography.h6,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    )
    Text(text = pet.description,
        textAlign = TextAlign.Justify,
        style = MaterialTheme.typography.body1,
        modifier = Modifier.padding(16.dp))
}


@Composable
fun Location(pet: Pet) {
    Row(
        modifier = Modifier.padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(Icons.Outlined.Place, null,
            modifier = Modifier
                .width(16.dp)
                .padding(end = 2.dp, top = 2.dp)
        )
        Text(text = pet.location,
            style = MaterialTheme.typography.body1,
        )
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PetCardInformation(pet: Pet){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        InfoCard(pet, title = stringResource(id = R.string.age_title),
            text = pet.dob.age())
        InfoCard(pet, title = stringResource(id = R.string.weight_title),
            text = "${pet.weight}lbs")
        InfoCard(pet, title = stringResource(id = R.string.sex_title),
            text = "")
    }
}

@Composable
fun InfoCard(pet: Pet, title: String, text: String){
    Card(modifier = Modifier
        .padding(start = 8.dp, end = 8.dp, top = 8.dp)
        .size(100.dp, 64.dp)
        .clip(MaterialTheme.shapes.medium),
        elevation = 8.dp,
        border = BorderStroke(1.dp, MaterialTheme.colors.outlineColor)
    ){
        if (text != "") {
            Column(verticalArrangement = Arrangement.Center){
                Text(text = title,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption
                )
                Text(text = text,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.SemiBold,
                    style = MaterialTheme.typography.body1)
            }
        } else {
            Column(verticalArrangement = Arrangement.Center) {
                Text(text = title,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.caption
                )
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    GenderIcon(pet = pet, modifier = Modifier.size(36.dp))
                }
            }
        }
    }
}


@Composable
fun AdoptButtonBar(){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start) {
        Button(
            modifier = Modifier
                .padding(16.dp)
                .weight(4f)
                .height(52.dp),
            onClick = { /*TODO*/ }) {
            Text(text = stringResource(id = R.string.adopt_button_title))
        }
        Button(
            colors = ButtonDefaults.buttonColors(backgroundColor = teal200),
            modifier = Modifier
                .padding(top = 16.dp, bottom = 16.dp, end = 16.dp)
                .weight(1f)
                .wrapContentWidth()
                .height(52.dp),
            onClick = { /*TODO*/ }) {
            Icon(Icons.Filled.Phone, "phone",
                tint = purple200,
                modifier = Modifier
                    .size(48.dp)
                    .padding(4.dp))
        }
    }
}