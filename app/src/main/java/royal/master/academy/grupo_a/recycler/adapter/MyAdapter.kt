package royal.master.academy.grupo_a.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import royal.master.academy.grupo_a.R
import royal.master.academy.grupo_a.recycler.data.UserItem
import royal.master.academy.grupo_a.utils.extension_fun.showToast

class MyAdapter(private val dataList : List<UserItem>) : RecyclerView.Adapter<RoyalViewHolder>(){

    /** */
    override fun getItemCount(): Int = dataList.size

    /** */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoyalViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return RoyalViewHolder(view)

    }

    /** */
    override fun onBindViewHolder(holder: RoyalViewHolder, position: Int) {

        val userItem : UserItem = dataList[position]

        with(userItem){

            val fullAddress = "${address.streetName} #${address.number},${address.zipCode}"

            holder.tvName.text = name
            holder.tvAge.text = "Edad : $age"
            holder.tvAddress.text = fullAddress

            val context = holder.itemView.context

            holder.btnDetail.setOnClickListener {
                context.showToast("Click en el item ${position+1}")
            }

        }



    }

}