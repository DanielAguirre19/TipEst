package mx.unam.fi.tipest.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.unam.fi.tipest.R
import mx.unam.fi.tipest.ui.components.TopBarSecundario
import mx.unam.fi.tipest.ui.list.AppConstants
import mx.unam.fi.tipest.ui.list.imagesRutas


@Composable
fun ImgPumaBusView(navController: NavController){
    val index = AppConstants.selectedRouteIndex
    Scaffold(
        topBar = {
            TopBarSecundario(navController, title = "Ruta $index")
        },
    ) {
        ContentImgPumaView(it = it)
    }
}

@Composable
fun ContentImgPumaView(it: PaddingValues) {
    val indexImg = AppConstants.selectedRouteIndex - 1
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 20.dp, end = 20.dp, top = 73.dp)
            .clip(RoundedCornerShape(16.dp))
            .padding(4.dp),
        color = Color.White,
        shadowElevation = 30.dp,
        shape = RoundedCornerShape(16.dp) // Forma del surface
    ) {
        Image(
            painter = painterResource(id = imagesRutas.getOrNull(indexImg) ?: R.drawable.muac),
            contentDescription = "Rutas",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.Crop
        )
    }
}


@Preview
@Composable
fun ImgPumaBusViewPreview(){
    val navController = rememberNavController()
    ImgPumaBusView(navController)
}