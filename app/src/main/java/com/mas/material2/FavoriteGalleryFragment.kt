package com.mas.material2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mas.material2.data.FavoriteViewModel


class FavoriteGalleryFragment : Fragment() {

    private lateinit var dataViewModel: FavoriteViewModel
    lateinit var adapter: RVAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataViewModel = ViewModelProvider(this).get(FavoriteViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main_gallery, container, false)
        val rv_card = view.findViewById<RecyclerView>(R.id.rv_card)
        rv_card.layoutManager = GridLayoutManager(view.context, 2)
        rv_card.setHasFixedSize(true)
        adapter = RVAdapter {
            //адаптер любимых
            //dataViewModel.add(it)
            //adapter.notifyDataSetChanged()
        }
        rv_card.adapter = adapter

        dataViewModel.viewState().observe(this, { state ->
            state?.let { state ->
                adapter.dataList = state
            }
        })

        return view
    }
}