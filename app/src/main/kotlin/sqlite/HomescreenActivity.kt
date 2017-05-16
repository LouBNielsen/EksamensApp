package sqlite

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_homescreen.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.onClick

class HomescreenActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homescreen)

        newPetButton.onClick {
            startActivity(intentFor<ActivityMain>())
        }

        sendSMSButton.onClick {
            startActivity(intentFor<SendSMS>())
        }
    }
}