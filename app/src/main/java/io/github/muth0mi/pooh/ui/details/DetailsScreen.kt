package io.github.muth0mi.pooh.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import io.github.muth0mi.pooh.data.models.Pet
import io.github.muth0mi.pooh.viewmodels.DetailsViewModel

@Composable
fun DetailsScreen(
    navController: NavHostController, petId: Int,
    detailViewModel: DetailsViewModel = viewModel()
) {
    val pet by detailViewModel.getPet(petId)

    Scaffold(
        topBar = { DetailsTopAppBar(pet, navController) },
        content = { DetailsScreenContent(pet, detailViewModel) }
    )
}

@Composable
private fun DetailsScreenContent(
    pet: Pet,
    detailViewModel: DetailsViewModel,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        DetailsSpecs(pet, detailViewModel)
        Spacer(modifier = Modifier.height(16.dp))
        DetailsGallery(pet.images)
        Spacer(modifier = Modifier.height(16.dp))
        DetailsMap(36.799090, -1.256911)
    }
}