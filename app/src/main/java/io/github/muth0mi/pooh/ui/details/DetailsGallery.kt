package io.github.muth0mi.pooh.ui.details

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssistantDirection
import androidx.compose.material.icons.filled.GridView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DetailsGallery(images: List<String>, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(16.dp).fillMaxWidth()) {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp, end = 16.dp, start = 16.dp)
            ) {
                Text(text = "Gallery", style = MaterialTheme.typography.h6)
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.GridView,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary
                    )
                }
            }
            val imagesChunks = images.chunked(2)
            Column(modifier = Modifier.padding(top = 16.dp)) {
                imagesChunks.forEach { imagesChunk ->
                    Row(modifier = Modifier.fillMaxWidth()) {
                        imagesChunk.forEach {
                            SmallImage(imageUrl = it, modifier = Modifier.weight(1f))
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SmallImage(imageUrl: String, modifier: Modifier = Modifier) {
    CoilImage(
        data = imageUrl,
        contentDescription = null,
        contentScale = ContentScale.FillWidth,
        alignment = Alignment.Center,
        modifier = modifier.clip(RoundedCornerShape(0))
    )
}