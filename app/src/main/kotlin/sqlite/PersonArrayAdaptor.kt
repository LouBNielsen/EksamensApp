package sqlite

/**
 * Created by LouiseB on 16-05-2017.
 */

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.person_item.view.*


class PersonArrayAdapter(context: Context, people: List<Pers>) :
        ArrayAdapter<Pers>(context, 0, people) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val person = getItem(position)
        var template : View =
                convertView ?:
                        LayoutInflater.from(context).inflate(R.layout.person_item, parent, false)
        template.firstName.text = person.firstName
        template.lastName.text = person.lastName
        return template

    }
}