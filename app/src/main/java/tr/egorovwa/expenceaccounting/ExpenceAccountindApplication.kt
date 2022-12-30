package tr.egorovwa.expenceaccounting

import android.app.Application
import tr.egorovwa.expenceaccounting.data.AppContainer
import tr.egorovwa.expenceaccounting.data.DefaultAppContainer

class ExpenceAccountindApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer(this)
    }
}