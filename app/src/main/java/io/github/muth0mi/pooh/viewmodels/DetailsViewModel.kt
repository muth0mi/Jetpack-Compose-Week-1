package io.github.muth0mi.pooh.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import io.github.muth0mi.pooh.data.models.Pet
import io.github.muth0mi.pooh.data.repositories.PetRepository

class DetailsViewModel(
    private val petRepository: PetRepository = PetRepository()
) : ViewModel() {

    fun getPet(petId: Int): MutableState<Pet> {
        petRepository.refreshPets()
        return mutableStateOf(petRepository.pets.value.first { it.id == petId })
    }

    val adopted = mutableStateOf(false)
    fun adoptPet(petId: Int) {
        adopted.value = true
    }

}