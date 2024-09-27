package com.example.assignment2

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val dataset = arrayOf(RecyclerViewItem("VanSamaOfficial", R.drawable.van_darkholme, "Hello!\nFull master is here!"),
            RecyclerViewItem("Franchesco Totti", R.drawable.francesco_totti, "Do you remember match against Australia?"),
            RecyclerViewItem("holebas_sead", R.drawable.parfenon, "Athens, Greece"),
            RecyclerViewItem("Radja Nainggolan", R.drawable.radja_nainggolan, "Good old times!\n#Belgium")
        )
        val myAdapter = MyAdapter(dataset)

        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = myAdapter
    }
}