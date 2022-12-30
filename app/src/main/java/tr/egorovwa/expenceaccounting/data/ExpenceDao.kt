package tr.egorovwa.expenceaccounting.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ExpenceDao {

    @Query("SELECT * FROM expence WHERE epochDay = :epochDay ORDER BY epochDay")
    fun getAllByDay(epochDay:Long):Flow<List<Expence>>
    @Query("SELECT * FROM expence ORDER BY epochDay")
    fun getAll():Flow<List<Expence>>

}