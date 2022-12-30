package tr.egorovwa.expenceaccounting.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import tr.egorovwa.expenceaccounting.ui.day.Day
import java.time.LocalDate

class OflineExpenceRepository(private val expenceDao: ExpenceDao) : ExpenceRepository {
    override fun getAllExpence(): Flow<List<Expence>> = expenceDao.getAll()
}