package sqlite

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.annotation.RequiresApi
import android.telephony.SmsMessage
import org.jetbrains.anko.toast


class SmsReceiver: BroadcastReceiver() {

    //@RequiresApi(Build.VERSION_CODES.M)

    override fun onReceive(context: Context, intent: Intent) {
        val intentExtras = intent.extras
        context.toast("Uhh")
        if (intentExtras != null) {
            val format = intentExtras.getString("format")
            val sms = intentExtras.get("pdus") as Array<Any>
            context.toast("Før ${sms.size}")
            for (i in sms.indices) {

                val smsMessage = SmsMessage.createFromPdu(sms[i] as ByteArray, format)

                val message = smsMessage.messageBody
                context.toast("hej")
                val parts = message.split(";")
                /*if(message.startsWith("#NEWPET")){
                    val name = parts[1]
                    val type = parts[2]
                    DBController.instance.insertPetFromSMS(name, type)
                    Toast.makeText(context, "New pet has been added: " + name + type, Toast.LENGTH_SHORT).show()
                } else
                    */
                    if(message.startsWith("#MEETING")){
                    val place = parts[1]
                    val time = parts[2]
                    context.toast("There is a meeting: $place $time")
                }
            }
        }
    }

}