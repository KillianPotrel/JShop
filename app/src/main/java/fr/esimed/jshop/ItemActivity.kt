package fr.esimed.jshop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import fr.esimed.jshop.model.data.Item
import fr.esimed.jshop.model.data.Liste
import fr.esimed.jshop.services.ApiInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ItemActivity : AppCompatActivity() {
    override fun onResume() {
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        val liste = intent.getSerializableExtra("Liste") as Liste
        getItemByList(liste)

        findViewById<TextView>(R.id.itemTitleList).text = "Liste : " + liste.shop

    }

    fun getItemByList(maList : Liste){
        val call = ApiInstance.createItem().getItemsByList(maList.id)
        call.enqueue(object : Callback<List<Item>> {
            override fun onResponse(call: Call<List<Item>>, response: Response<List<Item>>) {
                if (response.isSuccessful) {
                    val result = response.body()?.toMutableList()

                    val mesItems = findViewById<RecyclerView>(R.id.recyclerItemByList)
                    mesItems.layoutManager = LinearLayoutManager(this@ItemActivity)
                    mesItems.adapter = ItemAdapter(this@ItemActivity, response.body()!!)
                }
            }
            override fun onFailure(call: Call<List<Item>>, t: Throwable) {
                Toast.makeText(this@ItemActivity, t.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        })
    }
}