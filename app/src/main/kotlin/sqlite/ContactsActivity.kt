package sqlite

import android.app.Activity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_contacts.*
import org.jetbrains.anko.onClick


class ContactsActivity : Activity()
{

    val DBCtrl: DBController = DBController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

        println("i contakt aktivitet")
        petList()

       buttonGoBack.onClick { finish() }

    }

    fun petList() {
        println("petList metode")
        PetsList.adapter = PetAdapter(DBCtrl.getPets())

    }

}
