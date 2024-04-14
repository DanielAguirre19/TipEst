package mx.unam.fi.tipest.ui.components

import android.graphics.Color.parseColor
import android.icu.text.CaseMap.Title
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import mx.unam.fi.tipest.R
import mx.unam.fi.tipest.ui.views.MainTitle

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarSecundario(navController: NavController, title: String){
    CenterAlignedTopAppBar(
        title = { MainTitle(title = title) },
        navigationIcon = {
            IconButton(
                onClick = {navController.popBackStack() }
            ) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
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