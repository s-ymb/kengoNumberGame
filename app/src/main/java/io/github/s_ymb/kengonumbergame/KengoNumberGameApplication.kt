package io.github.s_ymb.kengonumbergame

import android.app.Application
import io.github.s_ymb.kengonumbergame.data.AppContainer
import io.github.s_ymb.kengonumbergame.data.AppDataContainer

class KengoNumberGameApplication : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }

}