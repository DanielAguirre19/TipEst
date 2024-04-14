package mx.unam.fi.tipest.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.unam.fi.tipest.R

val imagesListComida = listOf(
    R.drawable.cafe_fac_arq,
    R.drawable.cafe_fac_ciencias,
    R.drawable.cafe_fac_med,
)

val imagesListLugares = listOf(
    R.drawable.estadio,
    R.drawable.alberca,
    R.drawable.muac,
)

@Composable
fun HomeView(){
    Scaffold(
        topBar = {
            TopBar()
        },
        bottomBar = {
            TopBar()
        }
    ) {
        ContentHomeView(it = it)
    }
}

@Composable
fun ContentHomeView(it: PaddingValues){
    Column(
        modifier = Modifier.padding(it)
    ) {
        LazyColumn{
            item{
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.rectoria),
                        contentDescription = "Rectoría",
                        modifier = Modifier
                            .width(350.dp)
                            .height(220.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            item{
                Titulos(texto = "Lugares dónde comer")
            }
            item{
                LazyImages(images = imagesListComida)
            }

            item{
                Titulos(texto = "A dónde ir")
            }
            item{
                LazyImages(images = imagesListLugares)
            }

        }
    }
}

@Composable
fun MainTitle(title: String){
    Text(text= title, color = Color.Black, fontWeight = FontWeight.ExtraBold)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    CenterAlignedTopAppBar(
        title = { MainTitle(title = stringResource(id = R.string.app_name)) },
        navigationIcon = {
            IconButton(
                onClick = { /* Acción cuando se hace clic en el icono del mapa */ }
            ) {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "Mapa"
                )
            }
        },
        actions = {
            IconButton(
                onClick = { /* Acción cuando se hace clic en el icono de búsqueda */ }
            ) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Buscar"
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.White
        )
    )
}

@Composable
fun Titulos(texto: String){
    Text(
        text = texto,
        modifier = Modifier.padding(top = 16.dp, start = 25.dp),
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp

        )

    )
}

@Composable
fun LazyImages(images: List<Int>){
    LazyRow(
        modifier = Modifier.padding(vertical = 12.dp, horizontal = 22.dp)
    ) {
        items(images){ imageResource ->
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .padding(horizontal = 4.dp)
                    .clip(RoundedCornerShape(16.dp)),
                contentScale = ContentScale.Crop
            )
        }
    }
}


@Preview
@Composable
fun HomeViewPreview(){
    HomeView()
}