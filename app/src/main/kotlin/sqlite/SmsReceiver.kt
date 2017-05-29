package sqlite

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi
import android.telephony.SmsMessage
import org.jetbrains.anko.toast
import android.widget.Toast
import android.support.v4.app.NotificationCompat.getExtras
import android.os.Bundle
import android.util.Log
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.longToast
import org.jetbrains.anko.newTask
import java.io.IOException


class SmsReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {

        val extras = intent.extras ?: return
        val pdus = extras.get("pdus") as Array<Any>

        for (pdu in pdus) {
            val sms = SmsMessage.createFromPdu(pdu as ByteArray)
            val body = sms.messageBody
            val parts = body.split(";")

            try {
                if (body.startsWith("#MEETING")) {
                    val place = parts[1]
                    val time = parts[2]
                    context.toast("There is a meeting at: $place $time")
                    abortBroadcast()
                } else if (body.startsWith("#NEWPET")) {
                    val name = parts[1]
                    val type = parts[2]
                    context.toast("A new pet has been born: $name $type")
                    abortBroadcast()
                } else {
                    context.toast("$body")
                }
            } catch (exception : IOException){
                Log.d("", exception.toString())
            }
        }
    }
}