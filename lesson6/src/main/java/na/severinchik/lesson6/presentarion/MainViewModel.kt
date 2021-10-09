package na.severinchik.lesson6.presentarion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import na.severinchik.lesson6.App
import na.severinchik.lesson6.data.Responce
import na.severinchik.lesson6.data.entities.ResponceBreweries
import na.severinchik.lesson6.data.remotesource.TypeBrewery

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = (application as App).repository

    private val _state: MutableSharedFlow<Responce> = MutableSharedFlow()
    val state: SharedFlow<Responce> = _state

    fun getBreweries() {
        viewModelScope.launch {
            _state.emit(Responce.Loading)
            _state.emit(repository.getAllBrewery())
        }
    }

}