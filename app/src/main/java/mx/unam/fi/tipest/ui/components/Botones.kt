package mx.unam.fi.tipest.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun FloatButton(onClick: () -> Unit ){
    FloatingActionButton(
        onClick = onClick,
        containerColor = Color(0xFF1E4D51),  //0xFF96D783
        contentColor = Color.White
    ) {
        Icon(imageVector = Icons.Default.Edit, contentDescription = "Editar")
    }
}

@Preview(showBackground = true)
@Composable
fun FloatButtonPreview(){
    FloatButton {
    }
}