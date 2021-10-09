package na.severinchik.lesson6.data

import na.severinchik.lesson6.data.entities.ResponceBreweries

sealed class Responce {
    object Loading : Responce()
    data class Success(val responceBreweries: ResponceBreweries) : Responce()
    data class Error(val message: String) : Responce()
}
