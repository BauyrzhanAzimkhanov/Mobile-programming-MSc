package com.example.assignment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView

class ProfileFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataset = arrayListOf(RecyclerViewItem("VanSamaOfficial", R.drawable.van_darkholme, "Hello!\nFull master is here!"),
            RecyclerViewItem("Franchesco Totti", R.drawable.francesco_totti, "Do you remember match against Australia?"),
            RecyclerViewItem("holebas_sead", R.drawable.parfenon, "Athens, Greece"),
            RecyclerViewItem("Radja Nainggolan", R.drawable.radja_nainggolan, "Good old times!\n#Belgium")
        )
//        val gridViewAdapter = context?.let { GridViewAdapter(it, dataset) }
        val gridViewAdapter = GridViewAdapter(context, dataset)

        val gridView: GridView = view.findViewById(R.id.grid_view)
        gridView.adapter = gridViewAdapter
    }
}