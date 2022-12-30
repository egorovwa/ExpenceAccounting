package tr.egorovwa.expenceaccounting.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Expence::class], version = 1, exportSchema = false)
abstract class ExpenceDataBase : RoomDatabase() {
    abstract fun expenceDao(): ExpenceDao

    companion object {
        @Volatile
        private var Instance: ExpenceDataBase? = null
        fun getDataBase(context: Context): ExpenceDataBase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    ExpenceDataBase::class.java,
                    "expense_database"
                ).fallbackToDestructiveMigration()
                    .build().also { Instance = it }
            }
        }
    }
}