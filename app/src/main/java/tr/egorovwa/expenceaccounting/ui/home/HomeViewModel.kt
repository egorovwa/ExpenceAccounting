package tr.egorovwa.expenceaccounting.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import tr.egorovwa.expenceaccounting.data.ExpenceRepository
import tr.egorovwa.expenceaccounting.ui.day.Day
import java.time.LocalDate

class HomeViewModel(repository: ExpenceRepository) : ViewModel() {
    val homeUiState: StateFlow<HomeUiState> = repository.getAllExpence()
        .map {
          HomeUiState(it.groupBy{it.epochDay}
              .map { (epochDay, expences)-> Day(LocalDate.ofEpochDay(epochDay), expences) })
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIME_OUT),
            initialValue = HomeUiState()
        )

    companion object {
        private const val TIME_OUT = 5_000L
    }
}

data class HomeUiState(
    val days: List<Day> = listOf()
)