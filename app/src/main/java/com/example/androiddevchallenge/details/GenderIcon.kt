/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
import com.example.androiddevchallenge.ui.theme.lightBlue

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
