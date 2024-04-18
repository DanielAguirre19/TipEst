package mx.unam.fi.tipest.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mx.unam.fi.tipest.ui.views.DirectorioView
import mx.unam.fi.tipest.ui.views.HomeView
import mx.unam.fi.tipest.ui.views.ImgPumaBusView
import mx.unam.fi.tipest.ui.views.MapaView
import mx.unam.fi.tipest.ui.views.PefilView
import mx.unam.fi.tipest.ui.views.PumaBusView

@Composable
fun NavManager(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "HomeView") {
        composable("HomeView") {
            HomeView(navController)
        }
        composable("DirectorioView") {
            DirectorioView(navController)
        }
        composable("PerfilView") {
            PefilView(navController)
        }
        composable("PumabusView") {
            PumaBusView(navController)
        }

        composable("ImgPumabusView") {
            ImgPumaBusView(navController)
        }

        composable("MapaView") {
            MapaView(navController)
        }
    }
}