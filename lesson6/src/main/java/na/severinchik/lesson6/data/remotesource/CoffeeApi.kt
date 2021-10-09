package na.severinchik.lesson6.data.remotesource

import na.severinchik.lesson6.data.entities.CoffeeResponce
import retrofit2.http.GET

interface CoffeeApi {
    @GET("/random.json")
    suspend fun get():CoffeeResponce
}