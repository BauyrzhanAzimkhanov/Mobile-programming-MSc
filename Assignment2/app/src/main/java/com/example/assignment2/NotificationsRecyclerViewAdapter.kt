package com.example.assignment2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotificationsRecyclerViewAdapter(private val dataSet: ArrayList<NotificationsRecyclerViewItem>): RecyclerView.Adapter<NotificationsRecyclerViewAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val notificationItemView: TextView = view.findViewById(R.id.notification_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationsRecyclerViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.notifications_recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val likesItemTextViewText = dataSet[position].username + ": " + dataSet[position].action + " at " + dataSet[position].timestamp.toString()
        holder.notificationItemView.text = likesItemTextViewText
    }

    override fun getItemCount() = dataSet.size
}