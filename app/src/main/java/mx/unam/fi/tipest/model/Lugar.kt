package mx.unam.fi.tipest.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Lugar(
    @StringRes val stringResourceId: Int,
    @StringRes val telefonoResourceId: Int,
    @DrawableRes val drawableResourceId: Int

)
