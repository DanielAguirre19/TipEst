package mx.unam.fi.tipest.ui.views

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize

import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable


import androidx.compose.ui.Modifier

import androidx.compose.ui.tooling.preview.Preview

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
            TopBarSecundario(navController, title = "Directorio")
        },
    ) {
        ContentMapaView(it = it)
    }
}

@Composable
fun ContentMapaView(it: PaddingValues){
    val FI = LatLng(19.33120996609985, -99.18396542264932)


    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(FI, 16f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState,
        properties = MapProperties(isBuildingEnabled = true)
    ) {
        coordenadas.forEachIndexed { index, coordenada ->
            Marker(
                state = MarkerState(position = coordenada),
                title = nombresFac.getOrNull(index) ?: "Marcador $index",
                snippet = "Coordenadas: ${coordenada.latitude}, ${coordenada.longitude}",
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