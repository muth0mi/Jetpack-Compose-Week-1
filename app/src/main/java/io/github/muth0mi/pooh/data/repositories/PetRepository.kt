package io.github.muth0mi.pooh.data.repositories

import androidx.compose.runtime.mutableStateOf
import io.github.muth0mi.pooh.data.models.Pet

class PetRepository {

    private val allPets = listOf(
        Pet(name = "A", type = "Cat"),
        Pet(name = "B", type = "Cat"),
        Pet(name = "C", type = "Dog"),
        Pet(name = "D", type = "Other")
    )


    val pets = mutableStateOf(listOf<Pet>())
    fun refreshPets(petType: String? = null) {
        pets.value = if (petType == null) allPets else allPets.filter { it.type == petType }
        updatePetTypes()
    }


    val petsTypes = mutableStateOf(listOf<String>())
    private fun updatePetTypes() {
        petsTypes.value = allPets.map { it.type }.distinct().sorted()
    }

}
