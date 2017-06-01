package sqlite

import android.app.Application

class App : Application() {
    companion object {
        lateinit var instance: App private set
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}


    // lateinit:
    //              delegated property
    //              initialiser App inden dens dens state er tilgængelig / non-null type
    //              problem: ' var ' / companion object
    //              løsning: ' private set '



