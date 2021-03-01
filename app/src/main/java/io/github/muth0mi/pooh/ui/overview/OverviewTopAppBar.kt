package io.github.muth0mi.pooh.ui.overview

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import io.github.muth0mi.pooh.R
import io.github.muth0mi.pooh.viewmodels.OverviewViewModel


@Composable
fun OverviewTopAppBar(overviewViewModel: OverviewViewModel, modifier: Modifier = Modifier) {
    Surface(elevation = 1.dp, modifier = modifier) {
        Column {
            PoohTopAppBar()
            PetTypeTabs(overviewViewModel)
        }
    }
}

@Composable
private fun PoohTopAppBar(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.surface
) {
    TopAppBar(
        modifier = modifier,
        backgroundColor = backgroundColor,
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Home, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Settings, contentDescription = null)
            }
        },
        title = {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceAround,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 24.dp)
                ) { Text(text = stringResource(id = R.string.app_name)) }
            }
        }
    )
}

@Composable
private fun PetTypeTabs(
    overviewViewModel: OverviewViewModel,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.surface,
) {
    val petTypes = overviewViewModel.petsTypes.value

    if (petTypes.isNullOrEmpty() || overviewViewModel.selectedPetType.value == null) {
        if (!petTypes.isNullOrEmpty()) overviewViewModel.selectPetType(petTypes[0])
        return
    }

    val selectedIndex = petTypes.indexOfFirst { it == overviewViewModel.selectedPetType.value }

    val indicator = @Composable { tabPositions: List<TabPosition> ->
        val color = MaterialTheme.colors.primary.copy(alpha = .2F)
        PetTypeTabIndicator(
            Modifier
                .tabIndicatorOffset(tabPositions[selectedIndex])
                .background(color = color, shape = MaterialTheme.shapes.small)
        )
    }

    TabRow(
        selectedTabIndex = selectedIndex,
        indicator = indicator,
        backgroundColor = backgroundColor,
        modifier = modifier
    ) {
        petTypes.forEachIndexed { index, petType ->
            Tab(
                selected = index == selectedIndex,
                onClick = { overviewViewModel.selectPetType(petType) },
                content = {
                    Text(
                        text = petType,
                        style = MaterialTheme.typography.body2
                    )
                }
            )
        }
    }
}

@Composable
private fun PetTypeTabIndicator(modifier: Modifier = Modifier) {
    Spacer(
        modifier = modifier
            .padding(horizontal = 16.dp)
            .fillMaxHeight()
    )
}