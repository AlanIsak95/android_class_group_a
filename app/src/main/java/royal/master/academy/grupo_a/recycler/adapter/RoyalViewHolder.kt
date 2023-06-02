package royal.master.academy.grupo_a.recycler.adapter

import android.content.Context
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import royal.master.academy.grupo_a.R

class RoyalViewHolder(view : View) : RecyclerView.ViewHolder(view){

    val tvName : TextView = view.findViewById(R.id.tv_item_recycler_name)
    val tvAge : TextView = view.findViewById(R.id.tv_item_recycler_age)
    val tvAddress : TextView = view.findViewById(R.id.tv_item_recycler_address_value)
    val btnDetail : Button = view.findViewById(R.id.btn_item_recycler_detail)
    val btnBottomSheet : Button = view.findViewById(R.id.btn_item_recycler_bottom_sheet)
    val ivUserProfile : ImageView = view.findViewById(R.id.iv_item_recycler_image)

}