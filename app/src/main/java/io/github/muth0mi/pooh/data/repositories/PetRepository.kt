package io.github.muth0mi.pooh.data.repositories

import androidx.compose.runtime.mutableStateOf
import io.github.muth0mi.pooh.data.models.Pet
import io.github.muth0mi.pooh.data.models.PetGender

class PetRepository {

    private val allPets = listOf(
        Pet(
            id = 0,
            name = "A",
            type = "Cat",
            gender = PetGender.FEMALE,
            dob = 1577889029000,
            bio = "Simba has heart-stopping good looks, accented by his floppy ears. One day, after a really ling walk, he told us he ws ready for a snuggle session by jumping on the couch. Then he pawed te remote control and turned on the TV!.  We think he was trying to tell us he was trying to us he wanted to watch some Netflix! If hikes and Game Of Thrones are your thing, come and spend some time with Simba!",
            images = listOf()
        ),
        Pet(
            id = 1,
            name = "B",
            type = "Cat",
            gender = PetGender.FEMALE,
            dob = 1514817029000,
            bio = "Simba has heart-stopping good looks, accented by his floppy ears. One day, after a really ling walk, he told us he ws ready for a snuggle session by jumping on the couch. Then he pawed te remote control and turned on the TV!.  We think he was trying to tell us he was trying to us he wanted to watch some Netflix! If hikes and Game Of Thrones are your thing, come and spend some time with Simba!",
            images = listOf()
        ),
        Pet(
            id = 3,
            name = "D",
            type = "Other",
            gender = PetGender.FEMALE,
            dob = 1483281029000,
            bio = "Simba has heart-stopping good looks, accented by his floppy ears. One day, after a really ling walk, he told us he ws ready for a snuggle session by jumping on the couch. Then he pawed te remote control and turned on the TV!.  We think he was trying to tell us he was trying to us he wanted to watch some Netflix! If hikes and Game Of Thrones are your thing, come and spend some time with Simba!",
            images = listOf()
        ),
        Pet(
            id = 2,
            name = "Simba",
            type = "Dog",
            gender = PetGender.FEMALE,
            breed = "BUll dog",
            dob = 1609511429000,
            bio = "Simba has heart-stopping good looks, accented by his floppy ears. One day, after a really ling walk, he told us he ws ready for a snuggle session by jumping on the couch. Then he pawed te remote control and turned on the TV!.  We think he was trying to tell us he was trying to us he wanted to watch some Netflix! If hikes and Game Of Thrones are your thing, come and spend some time with Simba!",
            images = listOf(
                "https://images.squarespace-cdn.com/content/v1/51c30e7ce4b089f545ce58b3/1372097481530-PTVEWDS947B6KPROUGY4/ke17ZwdGBToddI8pDm48kP06O0_IHyRXSOOiqwgWaApZw-zPPgdn4jUwVcJE1ZvWEtT5uBSRWt4vQZAgTJucoTqqXjS3CfNDSuuf31e0tVEHLRkg2cosQUGLeQ33UzXdgIxPDaVwE3LlEpL74qP4JVW4jCyXLPvvdR287iymYt8/Beagle1.jpg",
                "https://mastiffmaster.com/wp-content/uploads/2018/05/angry-dog-square-1024x1024.jpg",
                "https://www.maxpixel.net/static/photo/640/Upside-Funny-Animal-Pet-Square-Dog-Upside-Down-2785076.jpg",
                "https://images.squarespace-cdn.com/content/v1/58b4791ad2b857c893179e34/1537971642021-LHW76T7O8JG0M4GLTSTP/ke17ZwdGBToddI8pDm48kP5vX5enzmFZg_sKw8AMeA97gQa3H78H3Y0txjaiv_0fDoOvxcdMmMKkDsyUqMSsMWxHk725yiiHCCLfrh8O1z5QHyNOqBUUEtDDsRWrJLTmJdLpeZW_ttQnjXwTxihzWAsJrSHjGKzvLdS9Q8LMXaA5Qe9yXehZ8OEZMevbfjkI/IMG_2818.jpg"
            )
        )
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
