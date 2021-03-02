package io.github.muth0mi.pooh.data.repositories

import androidx.compose.runtime.mutableStateOf
import io.github.muth0mi.pooh.data.models.Pet
import io.github.muth0mi.pooh.data.models.PetGender

class PetRepository {

    private val allPets = listOf(
        Pet(
            id = 0,
            name = "Bella",
            type = "Cat",
            size = "Small",
            color = "Grey",
            breed = "Maine Coon",
            gender = PetGender.FEMALE,
            dob = 1577889029000,
            images = listOf(
                "https://www.petspyjamas.com/uploads/2017/07/1lilbub-690x690.jpg",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSPNSHFdVDZlphl9dSuiaoOngxZRNzRwkQLaA&usqp=CAU",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVxXVGhJkOATH69VBDufDWR4buOruolcSHwA&usqp=CAU",
                "https://i.pinimg.com/originals/de/11/fa/de11fad7def7c3be26d71c8220904546.jpg",
            ),
            bio = "You know what they say, there are two means of refuge from the miseries of life: music and cats. Bella falls squarely on this adage and will purrr all the misery from. Visit our shelter today and hang out with lovely Bella.",
        ),
        Pet(
            id = 1,
            name = "Don Diego",
            type = "Cat",
            size = "Medium",
            color = "White",
            breed = "Persian",
            gender = PetGender.MALE,
            dob = 1514817029000,
            images = listOf(
                "https://media1.popsugar-assets.com/files/thumbor/0yzGDDV9odnhbWxGyqj_rkTCh9A/fit-in/2048xorig/filters:format_auto-!!-:strip_icc-!!-/2016/03/14/175/n/1922243/34cd38a3_edit_img_image_40425785_1457026505_12328447_1664411397144999_1750840461_n/i/Celebrity-Cats-Instagram.jpg",
                "https://i.pinimg.com/originals/43/87/03/438703b1f3f6384dd2c640dcd6fdef77.jpg",
                "https://i.pinimg.com/originals/a5/de/7d/a5de7dcc5ce7442fd4451c3303d09628.jpg",
                "https://i.pinimg.com/originals/8b/68/f2/8b68f21cfa09ecdd2b711bc4c419c8cb.jpg"
            ),
            bio = "Talk about the \"kitty good life\"! Don Diego has it all, from loving humans to his own fenced-in \"jungle\" and all the kitty perks that can be had. What to keep him? Visit us today!",
        ),
        Pet(
            id = 3,
            name = "Marty",
            type = "Other",
            size = "Large",
            color = "Rainbow",
            gender = PetGender.FEMALE,
            dob = 1483281029000,
            images = listOf(
                "https://img1.wsimg.com/isteam/ip/36db6b95-7ab1-47b7-a4c3-e6c1ea5491c6/IMG_1566.JPG/:/",
                "https://img1.wsimg.com/isteam/ip/36db6b95-7ab1-47b7-a4c3-e6c1ea5491c6/IMG_0119.JPG/:/cr=t:0%25,l:0%25,w:100%25,h:100%25",
                "https://img1.wsimg.com/isteam/ip/36db6b95-7ab1-47b7-a4c3-e6c1ea5491c6/IMG_0524-0001.JPG/:/cr=t:0%25,l:0%25,w:100%25,h:100%25"
            ),
            bio = "Hatched on 6/14/1990 in Sunnyvale Ca. Marty is a talented Triton Cockatoo. He is one of the original Happy Birds and has done more show than anyone! He loves giving kisses and showing off his amazing skills!  His very first performance was at Worlds of Fun Theme park in K.C. Mo. at the age of 2.",
        ),
        Pet(
            id = 2,
            name = "Simba",
            type = "Dog",
            size = "Medium",
            color = "Brown",
            gender = PetGender.FEMALE,
            dob = 1609511429000,
            breed = "Bull dog",
            images = listOf(
                "https://images.squarespace-cdn.com/content/v1/51c30e7ce4b089f545ce58b3/1372097481530-PTVEWDS947B6KPROUGY4/ke17ZwdGBToddI8pDm48kP06O0_IHyRXSOOiqwgWaApZw-zPPgdn4jUwVcJE1ZvWEtT5uBSRWt4vQZAgTJucoTqqXjS3CfNDSuuf31e0tVEHLRkg2cosQUGLeQ33UzXdgIxPDaVwE3LlEpL74qP4JVW4jCyXLPvvdR287iymYt8/Beagle1.jpg",
                "https://mastiffmaster.com/wp-content/uploads/2018/05/angry-dog-square-1024x1024.jpg",
                "https://www.maxpixel.net/static/photo/640/Upside-Funny-Animal-Pet-Square-Dog-Upside-Down-2785076.jpg"
            ),
            bio = "Simba has heart-stopping good looks, accented by his floppy ears. One day, after a really ling walk, he told us he ws ready for a snuggle session by jumping on the couch. Then he pawed te remote control and turned on the TV!.  We think he was trying to tell us he was trying to us he wanted to watch some Netflix! If hikes and Game Of Thrones are your thing, come and spend some time with Simba!",
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
