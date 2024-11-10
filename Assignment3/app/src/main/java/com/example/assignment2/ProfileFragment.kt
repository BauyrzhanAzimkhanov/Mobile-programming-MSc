package com.example.assignment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridView
import android.widget.ImageView
import android.widget.TextView

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
        val usernameReceived: String = arguments?.getString("username").toString().lowercase()
        val dataset = arrayListOf(
            RecyclerViewItem("VanSamaOfficial", R.drawable.van_darkholme, "Hello!\nFull master is here!", 69),
            RecyclerViewItem("Franchesco Totti", R.drawable.francesco_totti, "Do you remember match against Australia?", 10),
            RecyclerViewItem("Franchesco Totti", R.drawable.totti_family, "La cosa più preziosa della mia vita!", 17),
            RecyclerViewItem("Franchesco Totti", R.drawable.totti_nainggolan, "How are you doing my old friend? #radja_nainggolan", 29),
            RecyclerViewItem("Franchesco Totti", R.drawable.francesco_totti_captain, "La Roma è l’unica nel mio cuore!", 2582),
            RecyclerViewItem("holebas_sead", R.drawable.parfenon, "Athens, Greece", 1987),
            RecyclerViewItem("Radja Nainggolan", R.drawable.radja_nainggolan, "Good old times!\n#Belgium", 8)
        )
        val usersDataset = arrayListOf(
            UserItem("VanSamaOfficial", R.drawable.van_darkhome_profile, "Retired performance artist"),
            UserItem("Franchesco Totti", R.drawable.franchesco_totti_profile, "Ultimo imperatore di Roma"),
            UserItem("holebas_sead", R.drawable.sead_holebas_profile, "Reporter from Greece"),
            UserItem("Radja Nainggolan", R.drawable.radja_nainggolan_profile, "Official account from Radja Nainggolan...")
        )
        val profileImageView: ImageView = view.findViewById(R.id.profile_image_view)
        val usernameTextView: TextView = view.findViewById(R.id.username_text_view)
        val postCounterTextView: TextView = view.findViewById(R.id.post_counter_text_view)
        val biographyTextView: TextView = view.findViewById(R.id.biography_text_view)
        usernameTextView.text = usernameReceived
        biographyTextView.text = "No biography"
        var postsCounter: Int = 0
        var finalDataset: ArrayList<RecyclerViewItem> = ArrayList()
        dataset.forEach {
            if (it.username.lowercase().contains(usernameReceived)) {
                finalDataset.add(it)
                postsCounter++
            }
        }
        val postsCountText = "$postsCounter posts"
        postCounterTextView.text = postsCountText
        usersDataset.forEach {
            if (it.username.lowercase().contains(usernameReceived)) {
                profileImageView.setImageResource(it.profileImage)
                biographyTextView.text = it.biography
            }
        }
        val gridViewAdapter = GridViewAdapter(context, finalDataset)
        val gridView: GridView = view.findViewById(R.id.grid_view)
        gridView.adapter = gridViewAdapter
    }
}