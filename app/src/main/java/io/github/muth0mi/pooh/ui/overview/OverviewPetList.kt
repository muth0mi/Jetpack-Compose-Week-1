package io.github.muth0mi.pooh.ui.overview

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import io.github.muth0mi.pooh.data.models.Pet
import io.github.muth0mi.pooh.ui.Routes
import io.github.muth0mi.pooh.viewmodels.OverviewViewModel

@Composable
fun OverviewPetList(
    overviewViewModel: OverviewViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxSize().padding(top = 8.dp, bottom = 56.dp)) {
        items(
            count = overviewViewModel.pets.value.size,
            itemContent = {
                val pet = overviewViewModel.pets.value.getOrNull(it)
                pet?.let { PetCard(pet, navController) }
            }
        )
    }
}

@Composable
private fun PetCard(pet: Pet, navController: NavController, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.fillMaxWidth()
            .clickable(onClick = { navController.navigate(Routes.details) })
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Column {
            Text(text = pet.name)
        }
    }
}