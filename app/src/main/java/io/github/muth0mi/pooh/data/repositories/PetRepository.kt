package io.github.muth0mi.pooh.data.repositories

import androidx.compose.runtime.mutableStateOf
import io.github.muth0mi.pooh.data.models.Pet

class PetRepository {

    private val allPets = listOf(
        Pet(id = 0, name = "A", type = "Cat"),
        Pet(id = 1, name = "B", type = "Cat"),
        Pet(id = 2, name = "C", type = "Dog"),
        Pet(id = 3, name = "D", type = "Other")
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
