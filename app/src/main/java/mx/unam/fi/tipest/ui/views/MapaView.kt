package mx.unam.fi.tipest.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng

import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties

import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import mx.unam.fi.tipest.maps.coordenadas
import mx.unam.fi.tipest.maps.nombresFac
import mx.unam.fi.tipest.ui.components.TopBarSecundario

@Composable
fun MapaView(navController: NavController){
    Scaffold(
        topBar = {
            TopBarSecundario(navController, title = "Mapa de Ciudad Universitaria")
        },
    ) {
        ContentMapaView(it = it)
    }
}

@Composable
fun ContentMapaView(it: PaddingValues) {
    val selectedNombreIndex = remember { mutableIntStateOf(0) }
    val dropdownExpanded = remember { mutableStateOf(false) }

    val coordFI = LatLng(19.33120996609985, -99.18396542264932)


    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(coordFI, 16f)
    }

    Column(Modifier.fillMaxSize()) {
        // DropdownMenu
        Spacer(modifier = Modifier.size(70.dp))
        Box(modifier = Modifier.fillMaxWidth().background(Color(0xFFB1F49D)), contentAlignment = Alignment.Center) {
            TextButton(onClick = { dropdownExpanded.value = !dropdownExpanded.value }) {
                Text(nombresFac[selectedNombreIndex.intValue],
                    color = Color.Black,
                    style = MaterialTheme.typography.headlineMedium
                )
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = null,
                    tint = Color.Black
                )
            }
            DropdownMenu(
                expanded = dropdownExpanded.value,
                onDismissRequest = { dropdownExpanded.value = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp)
            ) {
                nombresFac.forEachIndexed { index, nombre ->
                    DropdownMenuItem(
                        text = {Text(text =  nombre)},
                        onClick = {
                            selectedNombreIndex.intValue = index
                            dropdownExpanded.value = false
                        }
                    )
                }
            }
        }
        GoogleMap(
            cameraPositionState = cameraPositionState,
            properties = MapProperties(isBuildingEnabled = true)
        ) {
            Marker(
                state = MarkerState(position = coordenadas[selectedNombreIndex.intValue]),
                title = nombresFac.getOrNull(selectedNombreIndex.intValue) ?: "Marcador",
                snippet = "Coordenadas: ${coordenadas[selectedNombreIndex.intValue].latitude}, ${coordenadas[selectedNombreIndex.intValue].longitude}"
            )
        }
    }
}


@Preview
@Composable
fun MapViewPreview(){
    val navController = rememberNavController()
    MapaView(navController)
}