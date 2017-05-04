package sqlite

import android.app.Application
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PetAdapter(var listPets: List<Map<String, Any?>>) : BaseAdapter() {

    override fun getView(position: Int, view: View?, viewGroup: ViewGroup): View {

        val viewPetsList = LayoutInflater.from(App.instance).inflate(R.layout.pet_list, viewGroup, false);

        val textViewPetName = viewPetsList.findViewById(R.id.petname) as TextView
        val textViewPetAge = viewPetsList.findViewById(R.id.petage) as TextView

        val item = getItem(position)

        textViewPetName.text = item["petName"].toString()
        textViewPetAge.text = item["petAge"].toString()

        println("petadapter")

        return viewPetsList
    }

    override fun getItem(position: Int): Map<String, Any?> {
        println("petadapter get")

        return listPets.get(position)
    }

    override fun getCount(): Int {
        println("petadapter get")

        return listPets.size
    }

    override fun getItemId(position: Int): Long {
        println("petadapter get")

        return getItem(position).get("petID") as Long;
    }
}