package na.severinchik.lesson5

import android.app.Application
import na.severinchik.lesson5.models.BankCardsStorage
import na.severinchik.lesson5.models.UserStorage

class App : Application() {

    private var _userStorage: UserStorage? = null
    val userStorage get() = _userStorage!!


    val bankCardsStorage = BankCardsStorage()

    override fun onCreate() {
        super.onCreate()
        _userStorage = UserStorage(this)

    }
}