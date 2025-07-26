package com.example.recyclerviewtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FruitAdapter(val fruitList:List<Fruit>) : RecyclerView.Adapter<FruitAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
        val fruitName: TextView = view.findViewById(R.id.fruitName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view =
            LayoutInflater.from(parent.context).inflate(R.layout.fruit_item, parent, false)
        var viewHolder = ViewHolder(view)
        viewHolder.itemView.setOnClickListener {
            var position = viewHolder.adapterPosition
            var fruit = fruitList[position]
            Toast.makeText(parent.context,"you clicked view ${fruit.name}",Toast.LENGTH_LONG).show()
        }
        viewHolder.fruitImage.setOnClickListener {
            var position = viewHolder.adapterPosition
            var fruit = fruitList[position]
            Toast.makeText(parent.context,"you clicked image ${fruit.name}",Toast.LENGTH_SHORT).show()
        }

        return viewHolder
    }

    override fun getItemCount(): Int = fruitList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var fruit = fruitList.get(position)
        holder.fruitImage.setImageResource(fruit.imgId)
        holder.fruitName.setText(fruit.name)
    }
}
