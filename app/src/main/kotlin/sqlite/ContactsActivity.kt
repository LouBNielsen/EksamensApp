package sqlite

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_contacts.*
import org.jetbrains.anko.*


class ContactsActivity : Activity(), AnkoLogger
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

       // peopleList.layoutManager = LinearLayoutManager(this)

        buttonGoBack.onClick { finish() }
    }

        override fun onResume() {
            super.onResume()
            //peopleList.adapter = PersonDbAdapter(DBController.instance.listPeople())
            personListView.adapter = PersonAdapter(DBController.instance.getAdapterLocations())

        }


}
