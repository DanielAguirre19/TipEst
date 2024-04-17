package mx.unam.fi.tipest.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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
import mx.unam.fi.tipest.ui.list.colorsList
import mx.unam.fi.tipest.ui.list.routes

@Composable
fun PumaBusView(navController: NavController){
    Scaffold(
        topBar = {
            TopBarSecundario(navController, title = "Pumabus")
        },
    ) {
        ContentPumabusView(it = it, navController = navController)
    }
}

@Composable
fun ContentPumabusView(it: PaddingValues, navController: NavController){
    Column(
        modifier = Modifier
            .padding(it)
            .fillMaxWidth()
    ) {
        LazyColumn {
            itemsIndexed(routes){ index, route ->
                //RouteItem(routeName = route, index = index, onClick = { navController.navigate("ImgPumaBusView")})
                RouteItem(routeName = route, index = index) {
                    AppConstants.selectedRouteIndex = index + 1
                    navController.navigate("ImgPumaBusView")
                    println("Índice: ${index + 1}")
                }
                if (index < routes.size - 1) {
                    Spacer(modifier = Modifier.height(8.dp))
                    Divider(color = Color.Gray, thickness = 3.dp)
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}

@Composable
fun RouteItem(routeName: String, index: Int, onClick: () -> Unit) {
    Surface(color = Color.White, modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CircleColor(index = index )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = routeName, style = MaterialTheme.typography.headlineSmall)
            }
        }
    }
}

@Composable
fun CircleColor(index: Int) {
    Surface(
        modifier = Modifier.size(24.dp),
        shape = CircleShape,
        color = colorsList.getOrNull(index % colorsList.size) ?: Color.Transparent
    ) {}
}


@Preview
@Composable
fun PumabusViewPreview(){
    val navController = rememberNavController()
    PumaBusView(navController)
}