package com.example.androiddevchallenge.list

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.text.input.TextFieldValue
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
            _petData.value = petRepository.getPetList()
        }
    }
}