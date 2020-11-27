package com.mas.material2

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mas.material2.data.DataClass


class RVAdapter(val onItemClick: ((DataClass) -> Unit)? = null) :
    RecyclerView.Adapter<RVAdapter.CardViewHolder>() {

    var dataList: MutableList<DataClass> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        CardViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_card, parent, false)
        )

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
        with(holder) {
            imgView.setImageResource(dataList.get(position).id)
            tvTitle.text = dataList.get(position).title

            imgView.setOnLongClickListener {
                dataList.removeAt(position)
                notifyDataSetChanged()
                Log.d("my", "longClick")
                return@setOnLongClickListener true
            }

            imgView.setOnClickListener {
                dataList.add(DataClass("New", dataList.get(position).id))
                notifyDataSetChanged()
            }
            fav.setOnClickListener {
                when (favNum) {
                    false -> {
                        fav.setImageResource(R.drawable.ic_baseline_favorite_24)
                        favNum = true
                        onItemClick?.invoke(
                            DataClass(dataList.get(position).title, dataList.get(position).id)
                        )
                    }
                    else -> {
                        fav.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                        favNum = false
                    }
                }
            }
        }
    }

    override fun getItemCount() = dataList.size

    inner class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var favNum = false
        val imgView: ImageView = view.findViewById(R.id.thumbnail)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val fav: FloatingActionButton = view.findViewById(R.id.favorite)
    }

}



