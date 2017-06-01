package sqlite

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_homescreen.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.onClick

class HomescreenActivity : Activity() {  // fundamental building block
    override fun onCreate(savedInstanceState: Bundle?) { // onCreate() starter life cycle ...
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)

        register.onClick {
            startActivity(intentFor<ActivityMain>())
        }

        sendSMSButton.onClick {
            startActivity(intentFor<SendSMS>())
        }
    }
}