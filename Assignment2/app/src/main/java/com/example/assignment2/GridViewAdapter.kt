package com.example.assignment2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView

internal class GridViewAdapter(
    private val context: Context,
    private val gridViewItemArrayList: ArrayList<RecyclerViewItem>
) :
BaseAdapter() {
    private var layoutInflater: LayoutInflater? = null
    private lateinit var image: ImageView
    override fun getCount(): Int {
        return gridViewItemArrayList.size
    }

    override fun getItem(position: Int): Any? {
        return null
    }

    override fun getItemId(position: Int): Long {
        return 0
    }\

    override fun getView(position: Int, gridItemView: View?, parent: ViewGroup?): View? {
        var gridItemView = gridItemView
        if (layoutInflater == null) {
            layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }
        if (gridItemView == null) {
            gridItemView = layoutInflater!!.inflate(R.layout.grid_view_item, null)
        }
        image = gridItemView!!.findViewById(R.id.image_mini_image_view)
        image.setImageResource(gridViewItemArrayList[position].image)
        return gridItemView
    }
}