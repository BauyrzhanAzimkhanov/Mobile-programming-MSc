package com.example.assignment2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdapter(private val dataSet: ArrayList<RecyclerViewItem>): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(), Filterable {
    private var initialDataSet = ArrayList<RecyclerViewItem>().apply {
        dataSet?.let { addAll(it) }
    }

    private val searchFilter: Filter = object: Filter() {
        override fun performFiltering(input: CharSequence?): FilterResults {
            val filteredArrayList: ArrayList<RecyclerViewItem> = ArrayList()
                if (input.isNullOrEmpty()) {
                initialDataSet.let { filteredArrayList.addAll(it) }
            }
            else {
                initialDataSet.forEach {
                    if (it.username.contains(input))
                     {
                        filteredArrayList.add(it)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredArrayList
            return results
        }

        override fun publishResults(input: CharSequence?, results: FilterResults?) {
            if(results?.values is ArrayList<*>) {
                dataSet.clear()
                dataSet.addAll(results.values as ArrayList<RecyclerViewItem>)
                notifyDataSetChanged()
            }
        }
    }

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val usernameItemView: TextView
        val imageItemView: ImageView
        val commentItemTextView: TextView
        init {
            usernameItemView = view.findViewById(R.id.username_item_text_view)
            imageItemView = view.findViewById(R.id.image_item_image_view)
            commentItemTextView = view.findViewById(R.id.comment_item_text_view)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.feed_recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.usernameItemView.text = dataSet[position].username
        holder.imageItemView.setImageResource(dataSet[position].image)
        holder.commentItemTextView.text = dataSet[position].comment
    }

    override fun getItemCount() = dataSet.size

    override fun getFilter(): Filter {
        return searchFilter
    }

}