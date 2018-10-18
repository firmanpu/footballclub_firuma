package com.firuma.footballclub

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.AnkoContext

class RecyclerViewAdapter(var list : MutableList<Item>, var listener : (Item) -> Unit) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(FootballUI().createView(AnkoContext.create(parent.context, parent)))
    }

    override fun getItemCount(): Int = list.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(list[position], listener)

    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        var imageView : ImageView
        var textView : TextView

        init {
            imageView = itemView.findViewById(FootballUI.imageId)
            textView = itemView.findViewById(FootballUI.nameId)
        }

        fun bindItem (items : Item, listener : (Item) -> Unit){
            textView.text = items.name
            Glide.with(itemView.context).load(items.image).into(imageView)
            itemView.setOnClickListener {
                listener(items)
            }
        }
    }
}