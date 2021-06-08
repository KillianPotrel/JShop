package fr.esimed.jshop

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.esimed.jshop.model.data.Item
import fr.esimed.jshop.model.data.Liste
import fr.esimed.jshop.services.ApiInstance
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat

class ItemAdapter (private val context: Context,
                   private val result : List<Item>) : RecyclerView.Adapter<ItemViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_cell,parent,false))
    }

    override fun getItemCount(): Int {
        return result.count()
    }

    @SuppressLint("ShowToast")
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var item = result[position] ?: return

        holder.tvItemName.text = item.label
        holder.tvItemQuantity.text = item.quantity
        holder.cbItem.isChecked = item.checked

        holder.cbItem.setOnClickListener {
            item.checked = !item.checked
            putItem(item,context)
            //Toast.makeText(context,"Vous cliquez sur la checkbox",Toast.LENGTH_LONG).show()
        }
    }


    fun putItem(item : Item, context: Context){
        val call = ApiInstance.createItem().putItemAPI(item)
        call.enqueue(object : Callback<ResponseBody> {
            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                if (response.isSuccessful) {
                    notifyDataSetChanged()
                }
            }
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                //recyclerListData.postValue(null)
                Toast.makeText(context, t.localizedMessage, Toast.LENGTH_LONG).show()
            }
        })
    }
}