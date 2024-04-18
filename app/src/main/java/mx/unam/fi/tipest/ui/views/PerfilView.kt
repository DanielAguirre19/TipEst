package mx.unam.fi.tipest.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.AbsoluteAlignment
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.unam.fi.tipest.R
import mx.unam.fi.tipest.ui.components.FloatButton
import mx.unam.fi.tipest.ui.components.TopBarSecundario

@Composable
fun PefilView(navController: NavController){
    Scaffold(
        topBar = {
            TopBarSecundario(navController, title = "Perfil")
        },
    ) {
        ContentPerfilView(it = it)
    }
}
@Composable
fun ContentPerfilView(it: PaddingValues){
    Column(
        modifier = Modifier.padding(it)
    ) {
        LazyColumn {
            item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Spacer(modifier = Modifier.height(20.dp))
                    Image(
                        painter = painterResource(id = R.drawable.perfil1),
                        contentDescription = "Perfil1",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(200.dp),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    //NOMBRE
                    Text(
                        text = "Alejandra Vásquez Castillo",
                        fontSize = 22.sp,
                        modifier = Modifier
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center,
                    )

                    Spacer(modifier = Modifier.height(70.dp))

                    //CORREO
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.gmail),
                            contentDescription = null,
                            modifier = Modifier
                                .size(35.dp)
                        )
                        Text(
                            text = "ale.vasquez@gmail.com",
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(10.dp))

                    //CELULAR
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.llamada),
                            contentDescription = null,
                            alignment = AbsoluteAlignment.CenterLeft,
                            modifier = Modifier
                                .size(35.dp)
                        )
                        Text(
                            text = "         55 1322 0195         ",
                            fontSize = 16.sp,
                            textAlign = TextAlign.Center,
                        )
                    }

                    Spacer(modifier = Modifier.height(10.dp))
                    Divider()
                    Spacer(modifier = Modifier.height(10.dp))

                    //FACULTAD
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.mapa),
                            contentDescription = null,
                            modifier = Modifier
                                .size(35.dp)
                                .fillMaxWidth()
                        )
                        Text(
                            text = "  Facultad de Ingeniería  ",
                            fontSize = 16.sp
                        )
                    }

                    Spacer(modifier = Modifier.height(80.dp))

                    FloatButton {}
                }
            }
        }
    }
}


@Preview
@Composable
fun PerfilViewPreview(){
    val navController = rememberNavController()
    PefilView(navController)
}