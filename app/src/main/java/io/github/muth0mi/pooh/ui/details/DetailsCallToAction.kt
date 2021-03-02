package io.github.muth0mi.pooh.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.github.muth0mi.pooh.data.models.Pet
import io.github.muth0mi.pooh.viewmodels.DetailsViewModel

@Composable
fun DetailsCallToAction(
    pet: Pet,
    detailViewModel: DetailsViewModel,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = pet.bio, modifier = Modifier.padding(vertical = 16.dp))

        Button(onClick = { detailViewModel.adoptPet(pet.id) }, modifier = Modifier.fillMaxWidth()) {
            Text(text = "Book An Appointment With ${pet.name}")
        }

        if (detailViewModel.adopted.value) AdoptedDialog(pet.name, detailViewModel)
    }
}

@Composable
private fun AdoptedDialog(name: String, detailViewModel: DetailsViewModel) {
    val dismiss = { detailViewModel.adopted.value = false }
    AlertDialog(
        title = { Text(text = "See you soon") },
        text = { Text("Appointment has been scheduled. Visit us on the location provided on the map to come meet $name!") },
        onDismissRequest = dismiss,
        buttons = {
            Button(onClick = dismiss, modifier = Modifier.padding(16.dp).fillMaxWidth()) {
                Text(text = "OK")
            }
        }
    )
}