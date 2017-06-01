package sqlite

import android.support.v7.widget.RecyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.person_item.view.*
import org.jetbrains.anko.AnkoLogger

class PersonDbAdapter(val people: List<Pers>) : RecyclerView.Adapter<PersonDbAdapter.ViewHolder>(), AnkoLogger {
    // Recycler view: view til at holde og vise data for et specifikt data item i adapter

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {

        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.person_item, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) { //vis data
        val person = people[position] //position af data item inde i adapteren
        holder.view.person_firstName.text = person.firstName
        holder.view.person_lastName.text = person.lastName
        holder.view.person_number.text = person.number.toString()
    }

    override fun getItemCount() = people.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)
}