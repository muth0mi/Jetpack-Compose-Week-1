package io.github.muth0mi.pooh.data.models

import java.util.*

enum class PetGender { MALE, FEMALE, UNKNOWN }

data class Pet(
    val id: Int,
    val name: String,
    val type: String,
    val gender: PetGender,
    val dob: Long,
    val breed: String? = null,
    val images: List<String>,
    val bio: String,
    val size: String,
    val color: String
) {
    fun getAge(): Int {
        val dob = Calendar.getInstance()
        dob.timeInMillis = this.dob

        val today = Calendar.getInstance()

        var age = today[Calendar.YEAR] - dob[Calendar.YEAR]
        if (today[Calendar.DAY_OF_YEAR] < dob[Calendar.DAY_OF_YEAR]) {
            age--
        }
        return age
    }
}