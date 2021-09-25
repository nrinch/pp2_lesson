package na.severinchik.lesson5.models

import android.app.Application

class UserStorage(application: Application) {
    private val users: List<User> = listOf(
        User("Mike", 42),
        User("Nike", 24)
    )

    fun getUsers() = users

}