package fr.esimed.jshop.services

import com.google.gson.JsonObject
import fr.esimed.jshop.model.data.Useraccount
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.*

interface UserAccountService {
    @FormUrlEncoded
    @Headers("Content-Type: application/x-www-form-urlencoded")
    @POST("useraccount/authenticate")
    fun loginUser(@Field("login") login : String, @Field("password") password : String) : Observable<JsonObject>


    @Headers("Content-Type: application/json")
    @GET("useraccount/key/{key}")
    fun getUserByKey(@Path("key") key : String): Call<Useraccount>
}