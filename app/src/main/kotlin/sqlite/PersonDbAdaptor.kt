package sqlite

import android.support.v7.widget.RecyclerView

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.person_item.view.*
import org.jetbrains.anko.db.INTEGER
import org.jetbrains.anko.onClick
import org.jetbrains.anko.toast

class PersonDbAdapter(val people: List<Pers>) :
        RecyclerView.Adapter<PersonDbAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : ViewHolder {

        val view = LayoutInflater
                .from(parent.context)
                .inflate(R.layout.person_item, parent, false)
        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.i("DBC", "pos: $position")
        val person = people[position]
        holder.view.firstName.text = person.firstName
        holder.view.lastName.text = person.lastName
        holder.view.number.text = person.number.toString()

    }

    override fun getItemCount() = people.size

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view)



}