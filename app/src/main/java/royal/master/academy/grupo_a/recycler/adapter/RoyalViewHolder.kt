package royal.master.academy.grupo_a.recycler.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import royal.master.academy.grupo_a.R

class RoyalViewHolder(view : View) : RecyclerView.ViewHolder(view){

    val itemName : TextView = view.findViewById(R.id.item_recycler_text)

}