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
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.longToast
import org.jetbrains.anko.newTask
import sqlite.PetsTable.id
import java.io.IOException


class SmsReceiver : BroadcastReceiver() { //fundamental building block

    override fun onReceive(context: Context, intent: Intent) { //intent connection mellem komponenter

        val extras = intent.extras ?: return // extra data information
        val pdus = extras.get("pdus") as Array<Any> // pdus format

        for (pdu in pdus) {
            val sms = SmsMessage.createFromPdu(pdu as ByteArray)
            val body = sms.messageBody
            val parts = body.split(";")

            try {
                if (body.startsWith("#MEETING")) {
                    val place = parts[1]
                    val time = parts[2]
                    context.toast("There is a meeting at: $place $time")
                    abortBroadcast() //afbryd
                } else if (body.startsWith("#NEWPET")) {
                    val name = parts[1]
                    val type = parts[2]

                    //var pet = Pets(name, type)
                    //DBController.instance.insertPet(name, type) // virker ikke .....

                    context.toast("A new pet has been born: - $name- -$type-") // virker på en måde .....

                    abortBroadcast()
                } else {
                    context.toast("$body")
                }
            } catch (exception : IOException){
                Log.d("exception", exception.toString())
            }
        }
    }
}