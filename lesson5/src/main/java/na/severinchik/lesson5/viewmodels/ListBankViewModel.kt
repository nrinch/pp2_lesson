package na.severinchik.lesson5.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import na.severinchik.lesson5.App
import na.severinchik.lesson5.models.BankCard

class ListBankViewModel(application: Application) : AndroidViewModel(application) {

    private val bankCardsStorage = (application as App).bankCardsStorage

    private val _cards: MutableSharedFlow<List<BankCard>> = MutableSharedFlow()
    val card: SharedFlow<List<BankCard>> = _cards

    fun fetchCards() {
        viewModelScope.launch {
            _cards.emit(bankCardsStorage.fetchCards())
        }
    }

}