package na.severinchik.lesson6.data.remotesource

import na.severinchik.lesson6.data.entities.ResponceBreweries
import retrofit2.http.GET
import retrofit2.http.Query

interface OpenBreweryApi {
    @GET("/breweries")
    suspend fun getAllBreweries(): ResponceBreweries

    @GET("/breweries")
    suspend fun getAllBreweriesByCity(@Query("by_city") city: String): ResponceBreweries

    @GET("/breweries")
    suspend fun getAllBreweriesByType(@Query("by_type") type: TypeBrewery): ResponceBreweries
}


sealed class TypeBrewery(type: String) {
    object MICRO : TypeBrewery("micro")
    object NANO : TypeBrewery("nano")
    object REGIONAL : TypeBrewery("regional")
    object BREWPUB : TypeBrewery("brewpub")
}


