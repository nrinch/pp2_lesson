package na.severinchik.lesson5.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel(val key: String) : ViewModel() {

    private val _data: MutableLiveData<String> = MutableLiveData()
    val data: LiveData<String> = _data

    fun fetchData() {
        _data.postValue("Hola From ViewModel $key")
    }

}