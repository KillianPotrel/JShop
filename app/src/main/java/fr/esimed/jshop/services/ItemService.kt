package fr.esimed.jshop.services

import fr.esimed.jshop.model.data.Item
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface ItemService {
    @Headers("Content-Type: application/json")
    @GET("item/list/{id}")
    fun getItemsByList(@Path("id") id : Int): Call<List<Item>>

    @Headers("Content-Type: application/json")
    @PUT("item")
    fun putItemAPI(@Body item: Item): Call<ResponseBody>
}