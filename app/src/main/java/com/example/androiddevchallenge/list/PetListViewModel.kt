package com.example.androiddevchallenge.list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.data.PetCategory
import com.example.androiddevchallenge.data.PetRepository
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.O)
class PetListViewModel : ViewModel() {

    private val petRepository = PetRepository()

    private val _petData = MutableLiveData<Map<PetCategory, List<Pet>>>()
    val petsData: LiveData<Map<PetCategory, List<Pet>>>
        get() = _petData

    init {
        viewModelScope.launch {
            val allAnimals = petRepository.getPetList()
            val groupedAnimals = allAnimals.groupBy { it.category }

            _petData.value = groupedAnimals
        }
    }
}