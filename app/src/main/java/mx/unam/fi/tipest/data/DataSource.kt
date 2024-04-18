package mx.unam.fi.tipest.data

import mx.unam.fi.tipest.R
import mx.unam.fi.tipest.model.Lugar

class DataSource {

    fun LoadLugares():List<Lugar>{
        return listOf<Lugar>(
            Lugar(R.string.auxilio,R.string.tel_auxilio,R.drawable.auxilio_unam),
            Lugar(R.string.med,R.string.tel_med,R.drawable.med),
            Lugar(R.string.sist,R.string.tel_salud,R.drawable.salud),
            Lugar(R.string.bomberos,R.string.tel_bomberos,R.drawable.bomberos)
        )
    }
}