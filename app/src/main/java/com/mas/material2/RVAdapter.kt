package com.mas.material2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mas.material2.data.DataClass
import com.mas.material2.data.DataClassRev


class RVAdapter(private val dataList: List<Any>) : RecyclerView.Adapter<RVAdapter.CardViewHolder>() {
    companion object {
        private const val DATA_CLASS = 0
        private const val DATA_CLASS_REV = 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            when (viewType) {
                DATA_CLASS -> CardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_card, parent, false))
                DATA_CLASS_REV -> CardViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.fragment_card_rev, parent, false))
                else -> throw IllegalStateException("Error viewType")
            }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {

        when (dataList.get(position)) {
            is DataClass -> {
                holder.imgView.setImageResource((dataList.get(position) as DataClass).id)
                holder.tvTitle.text = (dataList.get(position) as DataClass).title
            }
            is DataClassRev -> {
                holder.imgView.setImageResource((dataList.get(position) as DataClassRev).id)
                holder.tvTitle.text = (dataList.get(position) as DataClassRev).title
            }
            else -> throw IllegalStateException("Error viewType")
        }
    }

    override fun getItemViewType(position: Int): Int =
            when (dataList.get(position)) {
                is DataClass -> DATA_CLASS
                is DataClassRev -> DATA_CLASS_REV
                else -> throw IllegalStateException("Error viewType")
            }

    override fun getItemCount() = dataList.size

    class CardViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var favNum = false
        val imgView: ImageView = view.findViewById(R.id.thumbnail)
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val fav: FloatingActionButton = view.findViewById(R.id.favorite)

        init {
            fav.setOnClickListener {
                when (favNum) {
                    false -> {
                        fav.setImageResource(R.drawable.ic_baseline_favorite_24)
                        favNum = true
                    }
                    else -> {
                        fav.setImageResource(R.drawable.ic_baseline_favorite_border_24)
                        favNum = false
                    }
                }

            }
        }
    }

}



