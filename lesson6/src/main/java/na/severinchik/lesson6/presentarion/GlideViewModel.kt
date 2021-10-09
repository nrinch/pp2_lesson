package na.severinchik.lesson6.presentarion

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import na.severinchik.lesson6.App
import na.severinchik.lesson6.data.entities.CoffeeResponce

class GlideViewModel(application: Application) : AndroidViewModel(application) {
    val api = (application as App).apiCoffee

    private val _state: MutableSharedFlow<CoffeeResponce> = MutableSharedFlow()
    val state: SharedFlow<CoffeeResponce> = _state

    private val _stateFlow: MutableStateFlow<CoffeeResponce> =
        MutableStateFlow(CoffeeResponce(imageUrl = ""))
    val stateFlow: StateFlow<CoffeeResponce> = _stateFlow


    fun getNewPicture() {
        viewModelScope.launch {
            api.get()

            _state.emit(api.get())
        }
    }
}