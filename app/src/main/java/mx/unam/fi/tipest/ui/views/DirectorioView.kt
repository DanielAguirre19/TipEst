package mx.unam.fi.tipest.ui.views

import android.icu.text.CaseMap.Title
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import mx.unam.fi.tipest.R
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
    Column(
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
                        contentDescription = "Rectoría",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp)
                            .clip(RoundedCornerShape(16.dp)),
                        contentScale = ContentScale.Crop
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