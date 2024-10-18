package com.example.assignment2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NotificationsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.notifications_activity)
        val dataset = arrayListOf(RecyclerViewItem("VanSamaOfficial", R.drawable.francesco_totti, "Hello!\nFull master is here!"),
            RecyclerViewItem("Franchesco Totti", R.drawable.francesco_totti, "Do you remember match against Australia?"),
            RecyclerViewItem("holebas_sead", R.drawable.parfenon, "Athens, Greece"),
            RecyclerViewItem("Radja Nainggolan", R.drawable.radja_nainggolan, "Good old times!\n#Belgium")
        )
//        val recyclerViewAdapter = RecyclerViewAdapter(dataset)
//
//        val recyclerView: RecyclerView = findViewById(R.id.notifications_recycler_view)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = recyclerViewAdapter
    }
}