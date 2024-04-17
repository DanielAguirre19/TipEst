package mx.unam.fi.tipest.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.unam.fi.tipest.data.DataSource
import mx.unam.fi.tipest.model.Lugar
import mx.unam.fi.tipest.ui.components.TopBarSecundario


@Composable
fun DirectorioView(navController: NavController){
    Scaffold(
        topBar = {
            TopBarSecundario(navController, title = "Directorio")
        },
    ) {
        ContentDirView(it = it)
    }
}

@Composable
fun ContentDirView(it: PaddingValues){
    /*Column(
        modifier = Modifier.padding(it)
    ) {
        LazyColumn {
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.rectoria2),
                        contentDescription = "Hola",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
                    )
                }
            }
        }
    }*/
    CardList(it,lugarList = DataSource().LoadLugares())
}
@Composable
fun CardList(it:PaddingValues,lugarList: List<Lugar>, modifier: Modifier= Modifier   ){

    LazyColumn(modifier = modifier
            .padding(it)
            ,contentPadding = PaddingValues(horizontal = 10.dp, vertical = 8.dp)){
        items( lugarList ){
                lugar -> Card(
            lugar = lugar,
            modifier = modifier.padding(18.dp)
        )
        }
    }
}

@Composable
fun Card(lugar:Lugar, modifier: Modifier = Modifier ){
    Card (
        modifier=Modifier
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 20.dp,
        ),
                colors = CardDefaults.cardColors(
                containerColor = Color.White, //Card background color
    )
    ){
        Column {
            Row{
                Image(
                    painter = painterResource(id = lugar.drawableResourceId) ,
                    contentDescription = stringResource(id = lugar.stringResourceId),
                    modifier =
                    modifier
                        .size(100.dp)
                        .clip(RoundedCornerShape(15.dp))
                        .padding(2.dp),
                    contentScale = ContentScale.Crop
                )
                Column (
                    verticalArrangement = Arrangement.Center
                ){
                    Text(
                        text = LocalContext.current.getString(lugar.stringResourceId),
                        modifier = modifier.padding(horizontal=22.dp),
                        fontSize=18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = LocalContext.current.getString(lugar.telefonoResourceId),
                        modifier = modifier.padding(horizontal=22.dp),
                        fontSize=20.sp,
                        fontWeight = FontWeight.Light
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun DirectorioViewPreview(){
    val navController = rememberNavController()
    DirectorioView(navController)
}