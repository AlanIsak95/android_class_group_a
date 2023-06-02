package royal.master.academy.grupo_a.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import royal.master.academy.grupo_a.R
import royal.master.academy.grupo_a.recycler.data.ItemSelectedValue
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
                context.showToast("Ir a detalle")
            }

            holder.btnBottomSheet.setOnClickListener {
                ItemSelectedValue.selectUser(userItem)
                Navigation.findNavController(holder.itemView).navigate(R.id.action_recyclerFragment_to_detailBottomSheet)
            }

            Glide.with(context).load(imageURLValue).into(holder.ivUserProfile)


        }



    }

}