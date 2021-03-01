package io.github.muth0mi.pooh

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.muth0mi.pooh.ui.components.PoohTopAppBar
import io.github.muth0mi.pooh.ui.theme.PoohTheme

@Composable
@Preview(showBackground = true)
fun PoohApp() {
    PoohTheme {
        Scaffold(
            topBar = { PoohTopAppBar() }
        ) {}
    }
}