package sqlite

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.os.SystemClock
import kotlinx.android.synthetic.main.activity_sms.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.onClick
import org.jetbrains.anko.sendSMS

class SendSMS : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sms)

        // sendSMS: build-in sms manager
        buttonSendSMS1.onClick { sendSMS(phonenumber.text.toString(), message.text.toString()) }

        buttonSendSMS2.onClick {

            val number = "41100532" //Hvad vi har klikket på i contacts
            val text = "#MEETING"
            sendSMS(number, text) }

        contacts.onClick { startActivity(intentFor<ContactsActivity>()) }

        buttonGoBack.onClick { finish() }
    }
}

