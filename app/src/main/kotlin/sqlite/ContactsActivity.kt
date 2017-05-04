package sqlite

import android.app.Activity
import android.app.ListActivity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_contacts.*
import org.jetbrains.anko.onClick


class ContactsActivity : Activity()
{

    val DBCtrl: DBController = DBController()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

       buttonGoBack.onClick { finish() }

    }

}
