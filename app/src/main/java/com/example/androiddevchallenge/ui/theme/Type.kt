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
package com.example.androiddevchallenge.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R

val Teko = FontFamily(
    Font(R.font.teko_regular),
    Font(R.font.teko_medium, FontWeight.W500),
    Font(R.font.teko_bold, FontWeight.Bold)
)

val Hind = FontFamily(
    Font(R.font.hind_regular),
    Font(R.font.hind_medium, FontWeight.W500),
    Font(R.font.hind_bold, FontWeight.Bold)
)

private val defaultTypography = Typography()
val typography = Typography(
    h1 = defaultTypography.h1.copy(fontFamily = Teko),
    h2 = defaultTypography.h2.copy(fontFamily = Teko),
    h3 = defaultTypography.h3.copy(fontFamily = Teko),
    h4 = defaultTypography.h4.copy(fontFamily = Teko),
    h5 = defaultTypography.h5.copy(fontFamily = Teko),
    h6 = defaultTypography.h6.copy(fontFamily = Teko),
    subtitle1 = defaultTypography.subtitle1.copy(fontFamily = Teko),
    subtitle2 = defaultTypography.subtitle2.copy(fontFamily = Teko),
    body1 = TextStyle(
        fontFamily = Hind,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = Hind,
        fontWeight = FontWeight.W500,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = Teko,
        fontWeight = FontWeight.W500,
        fontSize = 30.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    overline = defaultTypography.overline.copy(fontFamily = Teko)
)
