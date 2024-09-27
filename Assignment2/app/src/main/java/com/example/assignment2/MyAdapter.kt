package com.example.assignment2

import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(private val dataSet: Array<RecyclerViewItem>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val usernameItemView: TextView
        val imageItemView: ImageView
        val commentItemTextView: TextView
        init {
            usernameItemView = view.findViewById(R.id.username_item_view)
            imageItemView = view.findViewById(R.id.image_item_view)
            commentItemTextView = view.findViewById(R.id.comment_item_text_view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.usernameItemView.text = dataSet[position].username
        holder.imageItemView.setImageResource(dataSet[position].image)
        holder.commentItemTextView.text = dataSet[position].comment
    }

    override fun getItemCount() = dataSet.size
}