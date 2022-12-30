package tr.egorovwa.expenceaccounting.data

import kotlinx.coroutines.flow.Flow

interface ExpenceRepository {
    fun getAllExpence():Flow<List<Expence>>
}