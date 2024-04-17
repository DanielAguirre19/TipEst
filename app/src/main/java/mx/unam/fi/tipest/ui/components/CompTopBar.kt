package mx.unam.fi.tipest.ui.components

import android.graphics.Color.parseColor
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import mx.unam.fi.tipest.ui.list.AppConstants
import mx.unam.fi.tipest.ui.views.MainTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarSecundario(navController: NavController, title: String){
    CenterAlignedTopAppBar(
        title = { MainTitle(title = title) },
        navigationIcon = {
            IconButton(
                onClick = {
                    navController.popBackStack()
                    AppConstants.selectedRouteIndex = -1
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = "Flecha",
                     tint = Color.White
                )
            }
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color(parseColor("#3b8132"))
        )
    )
}