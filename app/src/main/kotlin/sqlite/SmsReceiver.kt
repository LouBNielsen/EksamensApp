package sqlite

import android.app.Application

import android.annotation.TargetApi
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.telephony.SmsMessage
import android.widget.TextView
import android.widget.Toast
import android.support.v4.app.NotificationCompat.getExtras

class SmsReceiver: BroadcastReceiver() {

    @RequiresApi(Build.VERSION_CODES.M)
    @TargetApi(Build.VERSION_CODES.DONUT)

    override fun onReceive(context: Context, intent: Intent) {
        val intentExtras = intent.extras

        if (intentExtras != null) {
            val sms = intentExtras.get("pdus") as Array<Any>

            for (i in sms.indices) {

                val format = intentExtras.getString("format")
                val smsMessage = SmsMessage.createFromPdu(sms[i] as ByteArray, format)

                val phone = smsMessage.originatingAddress
                val message = smsMessage.messageBody.toString()

                val parts = message.split(";")
                if(message.startsWith("#SHOW")){
                    val name = parts[1]
                    val type = parts[2]
                    DBController.instance.insertPet(name, type)
                    Toast.makeText(context, "Your name is: " + name + type, Toast.LENGTH_SHORT).show()
                }

            }
        }
    }

}