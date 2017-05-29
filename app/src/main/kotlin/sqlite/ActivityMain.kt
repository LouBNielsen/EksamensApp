package sqlite

import android.app.Activity

import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class ActivityMain : Activity()
{
    companion object {
        val instance by lazy { ActivityMain() } //delegated property.. Instantieret ved første kald
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerPet.onClick {
            registerThisPet()
        }

        registerPers.onClick {
            registerThisPerson()
        }

        goBackButton.onClick {
            finish()
        }
    }

        fun registerThisPet(){
            //værdier fra textFields (layout activity_main)
            val fName = firstName.text.toString()
            val type = type.text.toString()

            DBController.instance.insertPet(fName, type) //puttes i DB
        }

        fun registerThisPerson(){
            //værdier fra textFields (layout activity_main)
            val fName = pFirstName.text.toString()
            val lName = pLastName.text.toString()
            val age = pAge.text.toString()
            val email = pEmail.text.toString()
            val number = pNumber.text.toString()

            DBController.instance.insertPerson(fName, lName, age, email, number) //puttes i DB
        }
}
