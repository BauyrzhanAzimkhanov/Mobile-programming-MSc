package com.example.assignment2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class NotificationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.notifications_activity)
        val dataset = arrayListOf(
            RecyclerViewItem("VanSamaOfficial", R.drawable.van_darkholme, "Hello!\nFull master is here!", 69),
            RecyclerViewItem("Franchesco Totti", R.drawable.francesco_totti, "Do you remember match against Australia?", 10),
            RecyclerViewItem("holebas_sead", R.drawable.parfenon, "Athens, Greece", 1987),
            RecyclerViewItem("Radja Nainggolan", R.drawable.radja_nainggolan, "Good old times!\n#Belgium", 8)
        )
//        val recyclerViewAdapter = RecyclerViewAdapter(dataset)
//
//        val recyclerView: RecyclerView = findViewById(R.id.notifications_recycler_view)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = recyclerViewAdapter
    }
}