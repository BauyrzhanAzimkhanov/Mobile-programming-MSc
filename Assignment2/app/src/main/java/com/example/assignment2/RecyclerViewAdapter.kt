package com.example.assignment2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView


class RecyclerViewAdapter(private val dataSet: ArrayList<RecyclerViewItem>, private val navigationController: NavController) :
    RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>(), Filterable {
    private var initialDataSet = ArrayList<RecyclerViewItem>().apply {
        addAll(dataSet)
    }

    private val searchFilter: Filter = object : Filter() {
        override fun performFiltering(input: CharSequence?): FilterResults {
            val filteredArrayList: ArrayList<RecyclerViewItem> = ArrayList()
            if (input.isNullOrEmpty()) {
                filteredArrayList.addAll(initialDataSet)
            } else {
                initialDataSet.forEach {
                    if (it.username.lowercase().contains(input)) {
                        filteredArrayList.add(it)
                    }
                }
            }
            val results = FilterResults()
            results.values = filteredArrayList
            return results
        }

        override fun publishResults(input: CharSequence?, results: FilterResults?) {
            if (results?.values is ArrayList<*>) {
                dataSet.clear()
                dataSet.addAll(results.values as ArrayList<RecyclerViewItem>)
                notifyDataSetChanged()
            }
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val usernameItemView: TextView = view.findViewById(R.id.username_item_text_view)
        val imageItemView: ImageView = view.findViewById(R.id.image_item_image_view)
        val commentItemTextView: TextView = view.findViewById(R.id.comment_item_text_view)
        val likesItemTextView: TextView = view.findViewById(R.id.likes_item_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.feed_recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.usernameItemView.text = initialDataSet[position].username
        holder.imageItemView.setImageResource(initialDataSet[position].image)
        holder.commentItemTextView.text = initialDataSet[position].comment
        var likesItemTextViewText: String = initialDataSet[position].likes.toString() + "likes"
        holder.likesItemTextView.text = likesItemTextViewText
        holder.usernameItemView.setOnClickListener {
            try {
                val transitionToProfileMenuAction = HomeFeedFragmentDirections.actionHomeFeedMenuToProfileMenu()
                navigationController.navigate(transitionToProfileMenuAction)
            }
            catch (exception: Exception) {
                println("Transited from wrong origin - HomeFeedFragment: $exception")
            }
            try {
                val transitionToProfileMenuAction = SearchFragmentDirections.actionSearchMenuToProfileMenu()
                navigationController.navigate(transitionToProfileMenuAction)
            }
            catch (exception: Exception) {
                println("Transited from wrong origin - SearchFragment: $exception")
            }
        }
        holder.likesItemTextView.setOnClickListener {
            initialDataSet[position].likes++
            likesItemTextViewText = initialDataSet[position].likes.toString() + "likes"
            holder.likesItemTextView.text = likesItemTextViewText
        }
    }

    override fun getItemCount() = dataSet.size

    override fun getFilter(): Filter {
        return searchFilter
    }

}