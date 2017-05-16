package sqlite

import android.app.Activity
import android.os.Bundle
import android.widget.ArrayAdapter

import kotlinx.android.synthetic.main.activity_contacts.*
import org.jetbrains.anko.onClick


class ContactsActivity : Activity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_people)
            peopleList.adapter = PersonArrayAdapter(
                    this,
                    people)
            peopleList.onItemClickListener = AdapterView.OnItemClickListener {
                parent, view, pos, id ->
                val clicked: Person = peopleList.getItemAtPosition(pos) as Person
                val intent = Intent(this, PersonActivity::class.java)

                intent.putExtra("person", clicked)
                startActivityForResult(intent, 4712)
            }
        }

        buttonGoBack.onClick { finish() }

    }


}
