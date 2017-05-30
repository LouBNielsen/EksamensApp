package sqlite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*



class PersonAdapter(var listPeople : List<Map<String, Any?>>) : BaseAdapter(){

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup?): View {
        val viewPersonList = LayoutInflater.from(App.instance).inflate(R.layout.person_item, viewGroup, false)

        val textViewFirstName = viewPersonList.findViewById(R.id.person_firstName) as TextView
        val textViewLastName = viewPersonList.findViewById(R.id.person_lastName) as TextView
        val textViewNumber = viewPersonList.findViewById(R.id.person_number) as TextView

        val item = getItem(position)

        textViewFirstName.text = item["firstName"].toString()
        textViewLastName.text = item["lastName"].toString()
        textViewNumber.text = item["number"].toString()

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