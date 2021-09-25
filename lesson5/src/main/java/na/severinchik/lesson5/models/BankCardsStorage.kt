package na.severinchik.lesson5.models

import android.graphics.Color

class BankCardsStorage {
    private val listBankCard: List<BankCard> = listOf(
        BankCard(
            number = "5234 4352 3452 1235",
            expireData = "12/25",
            owner = "John Malkovich",
            bankName = "BelarusBank",
            color = Color.CYAN,
            currency = "BYN"
        ),
        BankCard(
            number = "7456 7685 3452 1235",
            expireData = "12/25",
            owner = "Donald Trump",
            bankName = "AlfaBank",
            color = Color.RED,
            currency = "USD"

        ),
        BankCard(
            number = "7676 5974 3523 8675",
            expireData = "12/45",
            owner = "Kim chin in",
            bankName = "SwissBank",
            color = Color.MAGENTA,
            currency = "EUR"
        ),
        BankCard(
            number = "1234 5678 9043 3532",
            expireData = "05/08",
            owner = "Neo",
            bankName = "NewYorkBank",
            color = Color.GREEN,
            currency = "BTC"
        ),
        BankCard(
            number = "0987 6543 2112 3456",
            expireData = "02/25",
            owner = "Boris Britva",
            bankName = "BSB Bank",
            color = Color.DKGRAY,
            currency = "YAN"
        ),
    )

    fun fetchCards(): List<BankCard> {
        val biggestList = mutableListOf<BankCard>()
        for (i in 0..100) {
            biggestList.addAll(listBankCard)
        }
        return biggestList
    }
}