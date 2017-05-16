package sqlite

import android.app.Activity

import android.os.Bundle
import android.util.Log

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class ActivityMain : Activity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("vetApp", "in activity main")

        registerPet.setOnClickListener {
            toast("register")
            registerThisPet()
        }

        registerPers.setOnClickListener {
            toast("register")
            registerThisPerson()
        }

        goToSendSMS.onClick {
            startActivity(intentFor<SendSMS>())
        }
    }

        fun registerThisPet(){
            Log.d("vetApp", "in register pets")
            val fName = firstName.text.toString()
            val type = type.text.toString()

            DBController.instance.insertPet(fName, type)
        }

        fun registerThisPerson(){
            Log.d("vetApp", "in register pers")
            val fName = pFirstName.text.toString()
            val lName = pLastName.text.toString()
            val age = pAge.text.toString()
            val email = pEmail.text.toString()
            val number = pNumber.text.toString()

            DBController.instance.insertPerson(fName, lName, age, email, number)
        }
}
