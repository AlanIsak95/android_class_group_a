package royal.master.academy.grupo_a.recycler.adapter

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import royal.master.academy.grupo_a.R

class RoyalViewHolder(view : View) : RecyclerView.ViewHolder(view){

    val tvName : TextView = view.findViewById(R.id.tv_item_recycler_name)
    val tvAge : TextView = view.findViewById(R.id.tv_item_recycler_age)
    val tvAddress : TextView = view.findViewById(R.id.tv_item_recycler_address_value)
    val btnDetail : TextView = view.findViewById(R.id.btn_item_recycler_detail)

}