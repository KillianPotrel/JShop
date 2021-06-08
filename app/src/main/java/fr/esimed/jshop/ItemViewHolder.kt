package fr.esimed.jshop

import android.view.View
import android.widget.CheckBox
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewHolder (row : View) : RecyclerView.ViewHolder(row) {
    val tvItemName = row.findViewById<TextView>(R.id.rowItemName)
    val tvItemQuantity = row.findViewById<TextView>(R.id.rowItemQuantity)
    val cbItem =row.findViewById<CheckBox>(R.id.rowItemCheck)
}