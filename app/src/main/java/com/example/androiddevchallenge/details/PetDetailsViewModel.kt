package com.example.androiddevchallenge.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androiddevchallenge.data.Pet
import com.example.androiddevchallenge.data.PetRepository
import kotlinx.coroutines.launch

class PetDetailsViewModel : ViewModel() {
    private val petRepository = PetRepository()

    private val _petData = MutableLiveData<Pet>()
    val petData: LiveData<Pet>
        get() = _petData

    fun loadPetInfo(petId: String?) {
        viewModelScope.launch {
            _petData.value = petRepository.getPetById(petId)
        }
    }
}