package royal.master.academy.grupo_a.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import royal.master.academy.grupo_a.R

class MyAdapter(private val dataList : List<String>) : RecyclerView.Adapter<RoyalViewHolder>(){

    /** */
    override fun getItemCount(): Int = dataList.size

    /** */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoyalViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler,parent,false)
        return RoyalViewHolder(view)

    }

    /** */
    override fun onBindViewHolder(holder: RoyalViewHolder, position: Int) {

        val listValue = dataList[position]
        holder.itemName.text = listValue

    }

}