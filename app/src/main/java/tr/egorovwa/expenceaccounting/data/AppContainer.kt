package tr.egorovwa.expenceaccounting.data

import android.content.Context

interface AppContainer {
    val expenceRepository: ExpenceRepository
}

class DefaultAppContainer(context: Context) : AppContainer {
    override val expenceRepository: ExpenceRepository by lazy {
        OflineExpenceRepository(ExpenceDataBase.getDataBase(context).expenceDao())
    }

}