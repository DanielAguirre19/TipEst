package mx.unam.fi.tipest.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import mx.unam.fi.tipest.R
import mx.unam.fi.tipest.ui.list.imagesListAreas
import mx.unam.fi.tipest.ui.list.imagesListComida
import mx.unam.fi.tipest.ui.list.imagesListLugares
import mx.unam.fi.tipest.ui.list.titlesListAreas
import mx.unam.fi.tipest.ui.list.titlesListComida
import mx.unam.fi.tipest.ui.list.titlesListLugares
import android.graphics.Color.parseColor
import androidx.compose.material.icons.filled.Info
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


@Composable
fun HomeView(navController: NavController){
    Scaffold(
        topBar = {
            TopBar(navController)
        },
        bottomBar = {
            BottomBar(navController)
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
                        painter = painterResource(id = R.drawable.rectoria2),
                        contentDescription = "Rectoría",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
            }
            item{
                Titulos(texto = "Lugares dónde comer")
            }
            item{
                LazyImages(images = imagesListComida, titles = titlesListComida)
            }

            item{
                Titulos(texto = "A dónde ir")
            }
            item{
                LazyImages(images = imagesListLugares, titles = titlesListLugares)
            }

            item{
                Titulos(texto = "Áreas de estudio")
            }
            item{
                Areas(images = imagesListAreas, titles = titlesListAreas)
            }





        }
    }
}

@Composable
fun MainTitle(title: String){
    Text(text= title, color = Color.White, fontWeight = FontWeight.ExtraBold)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController){
    CenterAlignedTopAppBar(
        title = { MainTitle(title = stringResource(id = R.string.app_name)) },
        navigationIcon = {
            IconButton(
                onClick = { navController.navigate("MapaView")}
            ) {
                Icon(
                    imageVector = Icons.Filled.LocationOn,
                    contentDescription = "Mapa",
                    tint = Color.White
                )
            }
        },

        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(parseColor("#3b8132"))
        )
    )
}

@Composable
fun Titulos(texto: String){
    Text(
        text = texto,
        modifier = Modifier.padding(top = 16.dp, start = 22.dp),
        style = TextStyle(
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp

        )

    )
}

@Composable
fun LazyImages(images: List<Int>, titles:List<String>){
    LazyRow(
        modifier = Modifier.padding(vertical = 12.dp, horizontal = 20.dp)
    ) {
        itemsIndexed(images){ index, imageResource ->
            Column(
                modifier = Modifier.padding(horizontal = 4.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                Image(
                    painter = painterResource(id = imageResource),
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .padding(horizontal = 0.dp)
                        .clip(RoundedCornerShape(16.dp)),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = titles.getOrNull(index) ?: "",
                    modifier = Modifier.padding(top = 4.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    maxLines = 3,
                    overflow = TextOverflow.Clip
                )
            }
        }
    }
}

@Composable
fun Areas(images: List<Int>, titles:List<String>){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        images.forEachIndexed{ index, imageResoruce ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 16.dp / 2)
            ) {
                Image(
                    painter = painterResource(id = imageResoruce),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .aspectRatio(1f)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = titles.getOrNull(index) ?: "",
                    modifier = Modifier.padding(top = 4.dp),
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center,
                    maxLines = 3,
                    overflow = TextOverflow.Clip
                )
            }

        }
    }
}

@Composable
fun BottomBar(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(85 .dp)
            .background(Color(parseColor("#CCE7C9"))),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,

    ) {
        IconWithText(
            icon = Icons.Filled.Home,
            text = "Inicio",
            onClick = {},
            color = Color(0xFF287233)
        )
        IconWithText(
            icon = Icons.Filled.Phone,
            text = "Directorio",
            onClick = { navController.navigate("DirectorioView")},
            color = Color.DarkGray
        )
        IconWithText(
            icon = Icons.Filled.AccountCircle,
            text = "Perfil",
            onClick = {navController.navigate("PerfilView")},
            color = Color.DarkGray
        )
        IconWithText(
            icon = Icons.Filled.Info,
            text = "PumaBus",
            onClick = {navController.navigate("PumabusView")},
            color = Color.DarkGray
        )
    }
}

@Composable
fun IconWithText(icon: ImageVector, text: String, onClick: () -> Unit, color: Color) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        IconButton(onClick = onClick) {
            Icon(
                imageVector = icon,
                contentDescription = text,
                tint = color
            )
        }
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = color
        )
    }
}



@Preview
@Composable
fun HomeViewPreview(){
    val navController = rememberNavController()
    HomeView(navController)
}