package com.example.assignment2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.sql.Timestamp

class NotificationsFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notifications, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataset = arrayListOf(NotificationsRecyclerViewItem("holebas_sead", "liked your post", Timestamp(124, 10, 15, 14, 48, 3, 15)),
            NotificationsRecyclerViewItem("antoniocassano", "commented your post", Timestamp(124, 10, 12, 13, 37, 0, 28)),
            NotificationsRecyclerViewItem("dimitar_berbatov", "liked your post", Timestamp(124, 8, 29, 20, 44, 5, 36)),
            NotificationsRecyclerViewItem("methew_bal", "commented your post", Timestamp(124, 9, 3, 18, 58, 10, 69)),
            NotificationsRecyclerViewItem("honeymad", "liked your post", Timestamp(124, 6, 15, 14, 45, 23, 21)),
            NotificationsRecyclerViewItem("yasos_biba", "commented your post", Timestamp(124, 9, 11, 9, 28, 30, 31)),
            NotificationsRecyclerViewItem("lena-golovach", "liked your post", Timestamp(124, 10, 5, 12, 36, 32, 68)),
            NotificationsRecyclerViewItem("balotelli_mario", "commented your post", Timestamp(124, 10, 7, 22, 25, 11, 22)),
            NotificationsRecyclerViewItem("ravin_zilberman", "liked your post", Timestamp(124, 10, 8, 10, 14, 28, 99)),
            NotificationsRecyclerViewItem("m.martsinkevich", "commented your post", Timestamp(124, 10, 9, 11, 3, 0, 55)),
            NotificationsRecyclerViewItem("holebas_sead", "liked your post", Timestamp(124, 10, 15, 14, 48, 3, 15)),
            NotificationsRecyclerViewItem("antoniocassano", "commented your post", Timestamp(124, 10, 12, 13, 37, 0, 28)),
            NotificationsRecyclerViewItem("dimitar_berbatov", "liked your post", Timestamp(124, 8, 29, 20, 44, 5, 36)),
            NotificationsRecyclerViewItem("methew_bal", "commented your post", Timestamp(124, 9, 3, 18, 58, 10, 69)),
            NotificationsRecyclerViewItem("honeymad", "liked your post", Timestamp(124, 6, 15, 14, 45, 23, 21)),
            NotificationsRecyclerViewItem("yasos_biba", "commented your post", Timestamp(124, 9, 11, 9, 28, 30, 31)),
            NotificationsRecyclerViewItem("lena-golovach", "liked your post", Timestamp(124, 10, 5, 12, 36, 32, 68)),
            NotificationsRecyclerViewItem("balotelli_mario", "commented your post", Timestamp(124, 10, 7, 22, 25, 11, 22)),
            NotificationsRecyclerViewItem("ravin_zilberman", "liked your post", Timestamp(124, 10, 8, 10, 14, 28, 99)),
            NotificationsRecyclerViewItem("m.martsinkevich", "commented your post", Timestamp(124, 10, 9, 11, 3, 0, 55)),
            NotificationsRecyclerViewItem("holebas_sead", "liked your post", Timestamp(124, 10, 15, 14, 48, 3, 15)),
            NotificationsRecyclerViewItem("antoniocassano", "commented your post", Timestamp(124, 10, 12, 13, 37, 0, 28)),
            NotificationsRecyclerViewItem("dimitar_berbatov", "liked your post", Timestamp(124, 8, 29, 20, 44, 5, 36)),
            NotificationsRecyclerViewItem("methew_bal", "commented your post", Timestamp(124, 9, 3, 18, 58, 10, 69)),
            NotificationsRecyclerViewItem("honeymad", "liked your post", Timestamp(124, 6, 15, 14, 45, 23, 21)),
            NotificationsRecyclerViewItem("yasos_biba", "commented your post", Timestamp(124, 9, 11, 9, 28, 30, 31)),
            NotificationsRecyclerViewItem("lena-golovach", "liked your post", Timestamp(124, 10, 5, 12, 36, 32, 68)),
            NotificationsRecyclerViewItem("balotelli_mario", "commented your post", Timestamp(124, 10, 7, 22, 25, 11, 22)),
            NotificationsRecyclerViewItem("ravin_zilberman", "liked your post", Timestamp(124, 10, 8, 10, 14, 28, 99)),
            NotificationsRecyclerViewItem("m.martsinkevich", "commented your post", Timestamp(124, 10, 9, 11, 3, 0, 55)),
            )
        val notificationsRecyclerViewAdapter: NotificationsRecyclerViewAdapter = NotificationsRecyclerViewAdapter(dataset)
        val notificationsRecyclerView: RecyclerView = view.findViewById(R.id.notifications_recycler_view)
        notificationsRecyclerView.layoutManager = LinearLayoutManager(context)
        notificationsRecyclerView.adapter = notificationsRecyclerViewAdapter
    }
}