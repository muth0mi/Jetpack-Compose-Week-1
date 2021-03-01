package io.github.muth0mi.pooh.ui.overview

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import io.github.muth0mi.pooh.viewmodels.OverviewViewModel

@Composable
fun OverviewScreen(navController: NavController) {
    val overviewViewModel: OverviewViewModel = viewModel()

    Scaffold(
        topBar = { OverviewTopAppBar(overviewViewModel) },
        content = { OverviewPetList(overviewViewModel, navController) }
    )
}