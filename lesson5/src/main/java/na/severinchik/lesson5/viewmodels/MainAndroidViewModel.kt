package na.severinchik.lesson5.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import na.severinchik.lesson5.App
import na.severinchik.lesson5.models.User

class MainAndroidViewModel(application: Application) : AndroidViewModel(application) {

    private val userStorage = (application as App).userStorage

    private val _data: MutableLiveData<List<User>> = MutableLiveData()
    val data: LiveData<List<User>> = _data

    fun fetchData() {
        _data.postValue(userStorage.getUsers())
    }


}