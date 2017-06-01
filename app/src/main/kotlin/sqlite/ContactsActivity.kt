package sqlite

import android.app.ListActivity
import android.os.Bundle
import android.view.View
import android.widget.ListView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_contacts.*
import kotlinx.android.synthetic.main.person_item.view.*
import org.jetbrains.anko.*


class ContactsActivity : ListActivity(), AnkoLogger
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

       // peopleList.layoutManager = LinearLayoutManager(this)

       buttonGoBackTo.onClick { finish() }

    }


        override fun onResume() {
            super.onResume()
            //peopleList.adapter = PersonDbAdapter(DBController.instance.listPeople())
            list.adapter = PersonAdapter(DBController.instance.getAdapter())

        }

    override fun onListItemClick(l: ListView, v: View?, position: Int, id: Long) {
        val number = list.getChildAt(position).person_number.text
        Toast.makeText(this, "" + number, Toast.LENGTH_LONG).show()
        startActivity(intentFor<SendSMS>())
    }

}
