package sqlite

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_contacts.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.onClick
import org.jetbrains.anko.toast


class ContactsActivity : Activity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)
        peopleList.layoutManager = LinearLayoutManager(this)

        buttonGoBack.onClick { finish() }

    }

        override fun onResume() {

            super.onResume()
            peopleList.adapter = PersonDbAdapter(DBController.instance.listPeople())

        }



}
