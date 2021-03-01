package io.github.muth0mi.pooh.ui.details

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import io.github.muth0mi.pooh.viewmodels.DetailsViewModel

@Composable
fun DetailsScreen(
    navController: NavHostController, petId: Int,
    detailViewModel: DetailsViewModel = viewModel()
) {
    val pet by detailViewModel.getPet(petId)

    Scaffold(
        topBar = { DetailsTopAppBar(pet, navController) },
        content = {
//            OverviewPetList(detailViewModel, navController)
        }
    )
}