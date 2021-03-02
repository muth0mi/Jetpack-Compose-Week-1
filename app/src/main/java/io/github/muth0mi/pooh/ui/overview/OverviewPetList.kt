package io.github.muth0mi.pooh.ui.overview

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import dev.chrisbanes.accompanist.coil.CoilImage
import io.github.muth0mi.pooh.data.models.Pet
import io.github.muth0mi.pooh.ui.Routes
import io.github.muth0mi.pooh.viewmodels.OverviewViewModel

@Composable
fun OverviewPetList(
    overviewViewModel: OverviewViewModel,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier.fillMaxSize()) {
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
    val onClick = { navController.navigate("${Routes.details}/${pet.id}") }
    Card(
        modifier = modifier.fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .clickable(onClick = onClick)
    ) {
        Surface {
            BackgroundImage(imageUrl = pet.images.random(), Modifier.height(320.dp))
            Column(
                verticalArrangement = Arrangement.Bottom,
                modifier = Modifier.height(320.dp).fillMaxWidth().padding(16.dp)
            ) {
                Text(
                    text = pet.name,
                    style = MaterialTheme.typography.h4.copy(
                        fontFamily = FontFamily.Cursive,
                        fontWeight = FontWeight.ExtraBold
                    )
                )
                Text(
                    text = pet.bio,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    style = MaterialTheme.typography.body1.copy(fontFamily = FontFamily.Cursive)
                )
                Button(
                    onClick = onClick,
                    elevation = ButtonDefaults.elevation(0.dp),
                    modifier = Modifier.padding(top = 8.dp)
                        .background(MaterialTheme.colors.primary.copy(alpha = .2F))
                ) {
                    Text(
                        text = "More Details",
                        style = MaterialTheme.typography.button.copy(fontFamily = FontFamily.Serif)
                    )
                }
            }
        }
    }
}

@Composable
private fun BackgroundImage(imageUrl: String, modifier: Modifier = Modifier) {
    CoilImage(
        data = imageUrl,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        alignment = Alignment.Center,
        colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface, BlendMode.DstAtop),
        modifier = modifier.fillMaxWidth().clip(RoundedCornerShape(0)),
    )
}