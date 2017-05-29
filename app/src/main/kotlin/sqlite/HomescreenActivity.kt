package sqlite

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_homescreen.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.onClick

class HomescreenActivity : Activity() {  // fundamental building block
    override fun onCreate(savedInstanceState: Bundle?) { // onCreate() starter life cycle ... onStart(), onResume(), onStop() ...
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)

        register.onClick { // onClick listener
            startActivity(intentFor<ActivityMain>())
        }

        sendSMSButton.onClick {
            startActivity(intentFor<SendSMS>())
        }
    }
}