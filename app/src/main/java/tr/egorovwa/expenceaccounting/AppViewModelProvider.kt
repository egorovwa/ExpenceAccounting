package tr.egorovwa.expenceaccounting

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import tr.egorovwa.expenceaccounting.ui.home.HomeViewModel

object AppViewModelProvider {
    val factory = viewModelFactory {
        initializer {
            HomeViewModel(
                expenceAccouttingApplication().container.expenceRepository
            )
        }
    }
}

fun CreationExtras.expenceAccouttingApplication(): ExpenceAccountindApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as ExpenceAccountindApplication)