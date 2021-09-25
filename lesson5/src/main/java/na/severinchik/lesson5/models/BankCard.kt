package na.severinchik.lesson5.models

data class BankCard(
    val number: String,
    val expireData: String,
    val owner: String,
    val currency:String,
    val bankName: String,
    val color: Int
)
