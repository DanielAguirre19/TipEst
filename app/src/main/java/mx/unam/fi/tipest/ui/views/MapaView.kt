package mx.unam.fi.tipest.ui.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment


import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign

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
    val nombres = remember { nombresFac.toList() }
    val selectedNombreIndex = remember { mutableStateOf(0) }
    val dropdownExpanded = remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopBarSecundario(navController, title = "Mapa de Ciudad Universitaria")
        },
    ) {
        Column(Modifier.fillMaxSize()){
            DropdownMenu(
                expanded = dropdownExpanded.value,
                onDismissRequest = { dropdownExpanded.value = false }
            ){
                nombres.forEachIndexed { index, nombre ->
                    DropdownMenuItem(text = { "TODO" }, onClick = { /*TODO*/ })
                    /*DropdownMenuItem( onClick = {
                        selectedNombreIndex.value = index
                        dropdownExpanded.value = false
                    }){
                        Text(text = nombre)
                    }*/
                }
            }
            ContentMapaView(it = it)
        }
    }
}

@Composable
fun ContentMapaView(it: PaddingValues) {
    val selectedNombreIndex = remember { mutableStateOf(0) }
    val dropdownExpanded = remember { mutableStateOf(false) }

    val FI = LatLng(19.33120996609985, -99.18396542264932)


    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(FI, 16f)
    }

    Column(Modifier.fillMaxSize()) {
        // DropdownMenu
        Spacer(modifier = Modifier.size(70.dp))
        Box(modifier = Modifier.fillMaxWidth().background(Color(0xFFB1F49D)), contentAlignment = Alignment.Center) {
            TextButton(onClick = { dropdownExpanded.value = !dropdownExpanded.value }) {
                //Text(nombresFac[selectedNombreIndex.value])
                Text(
                    if (selectedNombreIndex.value == -1) {
                        "Selecciona una opción"
                    } else {
                        nombresFac[selectedNombreIndex.value]
                    },
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
                            selectedNombreIndex.value = index
                            dropdownExpanded.value = false
                        }
                    )
                }
            }
        }

        /*// Texto debajo del DropdownMenu
        Text(
            modifier = Modifier.padding(16.dp),
            text = "Opción seleccionada: ${nombresFac[selectedNombreIndex.value]}",
            style = MaterialTheme.typography.bodyMedium
        )*/

        GoogleMap(
            cameraPositionState = cameraPositionState,
            properties = MapProperties(isBuildingEnabled = true)
        ) {
            coordenadas.forEachIndexed { index, coordenada ->
                Marker(
                    state = MarkerState(position = coordenadas[selectedNombreIndex.value]),
                    title = nombresFac.getOrNull(selectedNombreIndex.value) ?: "Marcador",
                    snippet = "Coordenadas: ${coordenadas[selectedNombreIndex.value].latitude}, ${coordenadas[selectedNombreIndex.value].longitude}"
                )
            }
        }
    }
}


@Preview
@Composable
fun MapViewPreview(){
    val navController = rememberNavController()
    MapaView(navController)
}