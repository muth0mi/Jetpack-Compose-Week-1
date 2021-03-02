package io.github.muth0mi.pooh.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.muth0mi.pooh.data.models.Pet
import io.github.muth0mi.pooh.viewmodels.DetailsViewModel
import java.util.*

@Composable
fun DetailsSpecs(pet: Pet, detailViewModel: DetailsViewModel, modifier: Modifier = Modifier) {
    val specsModifier = Modifier.height(64.dp)

    Card(modifier = modifier.padding(16.dp).fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = pet.name, style = MaterialTheme.typography.h6)
                Text(
                    text = pet.type,
                    style = MaterialTheme.typography.body2,
                    color = MaterialTheme.colors.primary
                )
            }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
            ) {
                val locale = Locale.getDefault()
                val gender = pet.gender.name.toLowerCase(locale).capitalize(locale)

                PetSpec("Gender", gender, specsModifier)
                PetSpecSeparator(specsModifier)
                PetSpec("Breed", pet.breed ?: "Unknown", specsModifier)
                PetSpecSeparator(specsModifier)
                PetSpec("Age", "${pet.getAge()}", specsModifier)
                PetSpecSeparator(specsModifier)
                PetSpec("Size", "${pet.getAge()}", specsModifier)
                PetSpecSeparator(specsModifier)
                PetSpec("Color", "${pet.getAge()}", specsModifier)
            }

            DetailsCallToAction(pet, detailViewModel)
        }
    }
}

@Composable
private fun PetSpec(title: String, value: String, modifier: Modifier = Modifier) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Text(text = title, style = MaterialTheme.typography.subtitle2)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = value, style = MaterialTheme.typography.caption)

    }
}

@Composable
private fun PetSpecSeparator(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .width(1.dp)
            .background(MaterialTheme.colors.onBackground.copy(alpha = .2F))
    )
}