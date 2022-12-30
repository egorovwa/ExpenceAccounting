package tr.egorovwa.expenceaccounting.ui.day

import tr.egorovwa.expenceaccounting.data.Expence
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

data class Day(
    val date: LocalDate,
    val expenceList: List<Expence>
){
    fun getSum():Float{
        return expenceList.map { it.count* it.price }.sum()
    }
    fun getEpochDay():Long{
        return date.toEpochDay()
    }
}
val DATE_TIME_FORMATER = DateTimeFormatter.ofPattern("dd.MM.yyyy")