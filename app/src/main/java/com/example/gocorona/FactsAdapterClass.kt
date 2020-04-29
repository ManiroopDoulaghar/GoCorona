package com.example.gocorona


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/*This is FactsAdapterClass*/
/*Created by Doulaghar*/

class FactsAdapterClass(val factData : ArrayList<FactDataClass>):RecyclerView.Adapter<FactsAdapterClass.ViewHolder>() {

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int) : ViewHolder {
        val viewGenerator = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_layout, parent, false)
        return ViewHolder(viewGenerator)
    }   //End onCreateViewHolder

    override fun getItemCount(): Int {
        return factData.size
    }   //end getItemCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int){

        val factDataClass : FactDataClass = factData[position]
        holder.factDescTextView.text = factDataClass.factDesc
        holder.factExpTextView.text = factDataClass.factExp
        holder.separatorTextView.text="-----------------------------------------------------------------------------------------------------"
    }      //End onBindViewHolder

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val factDescTextView = itemView.findViewById<TextView>(R.id.factDescTextView)
        val factExpTextView = itemView.findViewById<TextView>(R.id.factExpTextView)
        val separatorTextView = itemView.findViewById<TextView>(R.id.separatorTextView)
    }   //End of Innerclass
}   //End of Adapter class