package fr.esimed.jshop

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.esimed.jshop.model.data.Liste
import java.text.SimpleDateFormat

class ListeMainAdapter(private val context: Context,
                        private val result : List<Liste>) : RecyclerView.Adapter<ListeMainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListeMainViewHolder {
        return ListeMainViewHolder(LayoutInflater.from(context).inflate(R.layout.list_cell,parent,false))
    }

    override fun getItemCount(): Int {
        return result.count()
    }

    override fun onBindViewHolder(holder: ListeMainViewHolder, position: Int) {
        val liste = result[position] ?: return

        holder.tvTitre.text = liste.shop
        val sdf = SimpleDateFormat("dd/MM/yyyy")
        val formatedDate = sdf.format(liste.date)
        holder.tvDate.text = formatedDate
        
        holder.btnShare.setOnClickListener {
            //etablissementDao.update(etablissement)
        }


        holder.itemView.setOnClickListener {
            //Start activity etablissement
            val intent = Intent(context, ItemActivity::class.java)
            intent.putExtra("Liste", liste)
            context.startActivity(intent)
        }
    }

}