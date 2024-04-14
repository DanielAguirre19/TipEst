package mx.unam.fi.tipest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import mx.unam.fi.tipest.navigation.NavManager

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavManager()
        }
    }
}
