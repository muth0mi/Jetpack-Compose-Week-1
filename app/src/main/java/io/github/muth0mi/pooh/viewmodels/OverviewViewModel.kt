package io.github.muth0mi.pooh.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import io.github.muth0mi.pooh.data.repositories.PetRepository

class OverviewViewModel(
    private val petRepository: PetRepository = PetRepository()
) : ViewModel() {

    val selectedPetType = mutableStateOf<String?>(null)
    fun selectPetType(petType: String) {
        selectedPetType.value = petType
        refreshPets()
    }


    val pets = petRepository.pets
    val petsTypes = petRepository.petsTypes
    private fun refreshPets() {
        petRepository.refreshPets(selectedPetType.value)
    }


    init {
        refreshPets()
    }
}