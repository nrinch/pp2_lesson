package na.severinchik.lesson6.data.entities

import com.google.gson.annotations.SerializedName
import kotlinx.serialization.SerialInfo
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CoffeeResponce(
    @SerializedName("file")
    val imageUrl: String
)