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


    // lateinit: initialiser en property, men dens state er endnu ikke tilgængelig..
    //           hvis værdi requestes før assignment --> exception
    //           lateinit kræver 'var'.. problem.. vi kan ændre værdien af instancen...
    //           løsning: 'private set'

    // delegate: properties med genbrugelig ædfærd.
    //           lazy, observable, values from a map



