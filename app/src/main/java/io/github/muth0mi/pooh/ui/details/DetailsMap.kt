package io.github.muth0mi.pooh.ui.details

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssistantDirection
import androidx.compose.material.icons.filled.Navigation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.ktx.addMarker
import com.google.maps.android.ktx.awaitMap
import kotlinx.coroutines.launch

@Composable
fun DetailsMap(latitude: Double, longitude: Double, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(16.dp).fillMaxWidth()) {
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp, end = 16.dp, start = 16.dp)
            ) {
                Text(text = "Location", style = MaterialTheme.typography.h6)
                IconButton(onClick = { }) {
                    Icon(
                        imageVector = Icons.Filled.AssistantDirection,
                        contentDescription = null,
                        tint = MaterialTheme.colors.primary
                    )
                }
            }

            Column(modifier = Modifier.padding(top = 16.dp).height(360.dp)) {
                val mapView = rememberMapViewWithLifecycle()
                MapViewContainer(mapView, latitude, longitude)
            }
        }
    }
}

@Composable
private fun MapViewContainer(map: MapView, latitude: Double, longitude: Double) {
    val zoom by rememberSaveable { mutableStateOf(1f) }
    val coroutineScope = rememberCoroutineScope()

    AndroidView({ map }) { mapView ->
        coroutineScope.launch {
            val googleMap = mapView.awaitMap()
            googleMap.setZoom(zoom)
            val position = LatLng(latitude, longitude)
            googleMap.addMarker { position(position) }
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(position))
        }
    }
}