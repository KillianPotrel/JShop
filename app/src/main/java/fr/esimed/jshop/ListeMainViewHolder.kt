package fr.esimed.jshop

import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListeMainViewHolder (row : View) : RecyclerView.ViewHolder(row) {
    val tvTitre = row.findViewById<TextView>(R.id.rowListName)
    val tvDate = row.findViewById<TextView>(R.id.rowListDate)
    val btnEdit =row.findViewById<ImageButton>(R.id.rowListButtonEdit)
    val btnShare =row.findViewById<ImageButton>(R.id.rowListButtonShare)
    val btnOpen =row.findViewById<ImageButton>(R.id.rowListButtonOpen)
}