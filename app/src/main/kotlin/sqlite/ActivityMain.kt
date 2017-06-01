package sqlite

import android.app.Activity

import android.os.Bundle

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*

class ActivityMain : Activity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        registerPetButton.onClick {
            registerThisPet()
        }

        registerPersonButton.onClick {
            registerThisPerson()
        }

        goBackButton.onClick {
            finish()
        }
    }

        fun registerThisPet(){
            val name = petName.text.toString()
            val type = petType.text.toString()

            DBController.instance.insertPet(name, type)
        }

        fun registerThisPerson(){
            val firstName = personFirstName.text.toString()
            val lastName = personLastName.text.toString()
            val age = personAge.text.toString()
            val email = personEmail.text.toString()
            val number = personNumber.text.toString()

            DBController.instance.insertPerson(firstName, lastName, age, email, number)
        }
}
