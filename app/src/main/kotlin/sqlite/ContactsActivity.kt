package sqlite

import android.app.Activity
import android.os.Bundle

import kotlinx.android.synthetic.main.activity_contacts.*
import org.jetbrains.anko.onClick


class ContactsActivity : Activity()
{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contacts)

       buttonGoBack.onClick { finish() }

    }

}
