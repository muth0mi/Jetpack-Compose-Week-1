package io.github.muth0mi.pooh.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.github.muth0mi.pooh.ui.details.DetailsScreen
import io.github.muth0mi.pooh.ui.overview.OverviewScreen
import io.github.muth0mi.pooh.ui.theme.PoohTheme

@Composable
@Preview(showBackground = true)
fun PoohApp() {
    PoohTheme {
        val navController = rememberNavController()

        NavHost(navController, startDestination = Routes.overview) {
            composable(Routes.overview) { OverviewScreen(navController) }
            composable(Routes.details) { DetailsScreen(navController) }
        }
    }
}

object Routes {
    const val overview = "overview"
    const val details = "details"
}