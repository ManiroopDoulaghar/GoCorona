package com.example.gocorona


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FactsAdapterClass(val factData : ArrayList<FactDataClass>):RecyclerView.Adapter<FactsAdapterClass.ViewHolder>() {
    /*
       * Adapter class is derived class from RecyclerView.Adapter.
       * This is implemented with JSON files(or for custom data with xml or db), when you may need a customized view with specific
       * number of textviews depending upon data
       * In this case, there are three text views that are needed to hold data from the json quotes file, plus one separtor.
       *
       * The adapter class will have to implement a viewHolder inner class and the overridden methods from the adapter base class.
       * onCreate viewholder class inflates the custom view.
       * OnBindViewHolder class binds the data to the views.
       * Data is passed to this class as an array list of type PotterQuoteDataClass , which is the data source.(from MainActivity)*/

    override fun onCreateViewHolder(parent:ViewGroup, viewType:Int) : ViewHolder {
        val viewGenerator = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_layout, parent, false)
        return ViewHolder(viewGenerator)
    }   //end onCreateViewHolder

    override fun getItemCount(): Int {
        return factData.size
    }   //end getItemCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int){
        //data binding

        val factDataClass : FactDataClass = factData[position]
        holder.factDescTextView.text = factDataClass.factDesc
        holder.factExpTextView.text = factDataClass.factExp
        holder.separatorTextView.text="-----------------------------------------------------------------------------------------------------"
    }      //end onBindViewHolder

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        //viewHolder for the textviews which hold the data
        //referencing the textviews.

        val factDescTextView = itemView.findViewById<TextView>(R.id.factDescTextView)
        val factExpTextView = itemView.findViewById<TextView>(R.id.factExpTextView)
        val separatorTextView = itemView.findViewById<TextView>(R.id.separatorTextView)
    }   //end innerclass
}   //end adapter class