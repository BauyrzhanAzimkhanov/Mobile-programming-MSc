package com.example.assignment2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.RecyclerView
import android.widget.SearchView

class SearchActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.search_activity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.search)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dataset = arrayListOf(
            RecyclerViewItem("VanSamaOfficial", R.drawable.van_darkholme, "Hello!\nFull master is here!", 69),
            RecyclerViewItem("Franchesco Totti", R.drawable.francesco_totti, "Do you remember match against Australia?", 10),
            RecyclerViewItem("holebas_sead", R.drawable.parfenon, "Athens, Greece", 1987),
            RecyclerViewItem("Radja Nainggolan", R.drawable.radja_nainggolan, "Good old times!\n#Belgium", 8)
        )
        val searchView: SearchView = findViewById(R.id.search_view)
        val recyclerView: RecyclerView = findViewById(R.id.search_activity_recycler_view)
//        val recyclerViewAdapter: RecyclerViewAdapter = RecyclerViewAdapter(dataset)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = recyclerViewAdapter
//        searchView.setOnQueryTextListener(object: SearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean {
//                recyclerViewAdapter.filter.filter(query)
//                return true
////                if (SearchRecyclerViewItem(query, dataset))
////                {
////                    recyclerViewAdapter!!.filter.filter(query)
////                }
////                else
////                {
////                    Toast.makeText(this@SearchActivity, "No Match found", Toast.LENGTH_LONG).show()
////                }
////                return false
//            }
//
//            override fun onQueryTextChange(newtext: String?): Boolean {
////                recyclerViewAdapter.filter.filter(newtext)
//                return false
//            }
//        })
    }

    fun SearchRecyclerViewItem(username: String, dataset: ArrayList<RecyclerViewItem>): Boolean {
        for (i in dataset.indices) {
            if (dataset[i].username == username)
            {
                return true;
            }
        }
        return false
    }
}