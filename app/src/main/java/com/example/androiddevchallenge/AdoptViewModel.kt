package com.example.androiddevchallenge

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.ZoneId
import java.time.ZonedDateTime

@RequiresApi(Build.VERSION_CODES.O)
class AdoptViewModel : ViewModel() {
    private val _animalsData = MutableLiveData<List<Pet>>()
    val petsData: LiveData<List<Pet>>
        get() = _animalsData

    init {
        // FIX: API data in a world where this is real
        val goat = Pet(
            "1",
            "Fred",
            PetCategory.Barnyard,
            PetSpecies.Goat,
            "",
            "https://picsum.photos/300/300",
            ZonedDateTime.of(2012, 2, 2, 4, 5, 0, 0, ZoneId.systemDefault()),
            Gender.NonBinary,
            2.0f,
            LongLatLocale(25.3f, 23.12f)
        )
        val pig = Pet(
            "1",
            "Fred",
            PetCategory.Barnyard,
            PetSpecies.Pig,
            "",
            "https://picsum.photos/300/300",
            ZonedDateTime.of(2012, 2, 2, 4, 5, 0, 0, ZoneId.systemDefault()),
            Gender.NonBinary,
            2.0f,
            LongLatLocale(25.3f, 23.12f)
        )

        _animalsData.value = listOf(goat, pig)
    }
}