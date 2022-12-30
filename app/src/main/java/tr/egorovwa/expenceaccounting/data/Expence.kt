package tr.egorovwa.expenceaccounting.data

import androidx.room.*

@Entity(tableName = "expence")
data class Expence(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val price: Float,
    val count: Float,
    val epochDay: Long,
    val category: Category

)
@ProvidedTypeConverter
class typeConverter{
    @TypeConverter
    fun toCategory(categoryStr: String):Category{
        return Category.valueOf(categoryStr)
    }
    @TypeConverter
    fun fromCategory(category: Category):String{
        return category.toString()
    }
}

enum class Category {
    FOOD,
    FUEL,
    AVTO,
    ALCOGOL,
    TOBACCO
}

