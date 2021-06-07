package fr.esimed.jshop.services

import retrofit2.http.GET
import fr.esimed.jshop.model.data.Liste
import retrofit2.Call
import retrofit2.http.Headers
import retrofit2.http.Path

interface ListService {
    @Headers("Content-Type: application/json")
    @GET("list/user/{id}")
    fun getListByUser(@Path("id") id : String): Call<List<Liste>>
    
    @Headers("Content-Type: application/json")
    @GET("list/current")
    fun getCurrentList(): Call<List<Liste>>
}