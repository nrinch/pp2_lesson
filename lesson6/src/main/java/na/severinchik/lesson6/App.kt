package na.severinchik.lesson6

import android.app.Application
import na.severinchik.lesson6.data.BreweryRepository
import na.severinchik.lesson6.data.remotesource.CoffeeApi
import na.severinchik.lesson6.data.remotesource.OpenBreweryApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.openbrewerydb.org/"
private const val BASE_COFFEE_URL = "https://coffee.alexflipnote.dev/"

class App : Application() {

    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    private val httpClint = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private val clientRetrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClint)
        .build()

    private val clientCofferRetrofit = Retrofit.Builder()
        .baseUrl(BASE_COFFEE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClint)
        .build()


    private val apiBrewery get() = clientRetrofit.create(OpenBreweryApi::class.java)
    val apiCoffee get() = clientCofferRetrofit.create(CoffeeApi::class.java)


    val repository = BreweryRepository(apiBrewery)

    override fun onCreate() {
        super.onCreate()
    }
}