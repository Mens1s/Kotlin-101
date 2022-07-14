package com.example.superherobook

import android.content.Intent
import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_row.view.*

class RecyclerAdapter( val superheroList : ArrayList<String>, val supeheroImages : ArrayList<Int>) : RecyclerView.Adapter<RecyclerAdapter.SuperHeroVH>() {
    class SuperHeroVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperHeroVH {
        // inflater, layoutinflater, menuinflater
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.recycler_row,parent,false)
        return SuperHeroVH(itemView)
    }

    override fun onBindViewHolder(holder: SuperHeroVH, position: Int) {
        holder.itemView.recyclerViewTextView.text = superheroList.get(position)
        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, ShowHero::class.java)
            intent.putExtra("superheroName",superheroList.get(position))
            intent.putExtra("superheroIMG",supeheroImages.get(position))
            /*
            val singleton = singletonClass.currHero
            singleton.img = supeheroImages.get(position)
            */
            holder.itemView.context.startActivity(intent)

        }
    }

    override fun getItemCount(): Int {
        return superheroList.size
    }

}