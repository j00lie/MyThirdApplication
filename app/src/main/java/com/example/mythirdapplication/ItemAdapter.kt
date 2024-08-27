package com.example.mythirdapplication

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ItemAdapter(context: Context, private val items: Array<String>, private val prices: Array<String>, private val descriptions: Array<String>)
    : ArrayAdapter<String>(context, R.layout.my_listview_detail, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.my_listview_detail, parent, false)

        // Find views in the custom layout
        val itemName = view.findViewById<TextView>(R.id.nameTextView)
        val itemPrice = view.findViewById<TextView>(R.id.priceTextView)
        val itemDescription = view.findViewById<TextView>(R.id.descriptionTextView)

        // Set the text for each view
        itemName.text = items[position]
        itemPrice.text = prices[position]
        itemDescription.text = descriptions[position]

        return view
    }
}
