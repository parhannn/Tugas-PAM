package com.example.app.ui.skill

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.app.R
import com.google.android.material.imageview.ShapeableImageView


class MyAdapter(private var list: ArrayList<Skill>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    var onItemClick : ((Skill) -> Unit)? = null

    fun setFilteredList(list: ArrayList<Skill>){
        this.list = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item , parent , false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = list[position]
        holder.titleImage.setImageResource(currentItem.titleImage)
        holder.tvHeading.text = currentItem.heading

        holder.itemView.setOnClickListener {
            onItemClick?.invoke(currentItem)
        }
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){

        val titleImage : AppCompatImageView = itemView.findViewById(R.id.imageView)
        val tvHeading : TextView = itemView.findViewById(R.id.titleImage)

    }
}