package com.example.yemektariflerisqlite

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recyclerrow.view.*

class ListeRecyclerAdapter (val yemekListesi : ArrayList<String>, val idListesi : ArrayList<Int>) :
    RecyclerView.Adapter<ListeRecyclerAdapter.YemekHolder>() {
    class YemekHolder(itemView: View):RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemekHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.recyclerrow, parent, false)
        return YemekHolder(view)
    }

    override fun onBindViewHolder(holder: YemekHolder, position: Int) {
        holder.itemView.testRec.text = yemekListesi[position]
        holder.itemView.setOnClickListener{
            val action = ListeFragmentDirections.actionListeFragmentToTarifFragment("recyclerdangeldim", position)
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return yemekListesi.size
    }
}