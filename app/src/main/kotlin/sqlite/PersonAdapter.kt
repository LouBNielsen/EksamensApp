package sqlite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import kotlinx.android.synthetic.main.person_item.view.*


class PersonAdapter(var listPeople : List<Map<String, Any?>>) : BaseAdapter(){ //Adapter binder view og data

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        //view indeholder viewGroup
        //viewGroup indeholder children views. view container

        //LayoutInflater: XML fil konvertering til View objekter
        val viewPersonList = LayoutInflater.from(App.instance).inflate(R.layout.person_item, viewGroup, false)

        val item = getItem(position)

        //view objekter til db objekter
        viewPersonList.person_firstName.text = item["firstName"].toString()
        viewPersonList.person_lastName.text = item["lastName"].toString()
        viewPersonList.person_number.text = item["number"].toString()


        return viewPersonList
    }

    override fun getItem(position: Int): Map<String, Any?> {
        return listPeople.get(position)
    }

    override fun getCount(): Int {
        return listPeople.size
    }


    override fun getItemId(position: Int): Long {
        return getItem(position).get("id") as Long

    }


}