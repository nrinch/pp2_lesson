package na.severinchik.lesson6.data

import na.severinchik.lesson6.data.remotesource.OpenBreweryApi
import java.lang.Error
import java.lang.Exception

class BreweryRepository(private val api: OpenBreweryApi) {
    suspend fun getAllBrewery(): Responce {
        return try {
            Responce.Success(api.getAllBreweries())
        } catch (e: Exception) {
            Responce.Error(e.message.toString())
        }
    }
}