package fr.esimed.jshop.services

import fr.esimed.jshop.model.data.Useraccount
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

abstract class ApiInstance {
    companion object {
        var tokenUser : String? = null
        val baseURL = "http://ec2-54-152-62-32.compute-1.amazonaws.com:3333/"

        fun httpClient(): OkHttpClient {
            val httpClient = OkHttpClient.Builder()
            httpClient.addInterceptor(Interceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .addHeader("Authorization", "Bearer ${tokenUser}")
                    .build()
                chain.proceed(request)
            })
            return httpClient.build()
        }

        fun createClient(): UserAccountService {
            val httpClient = httpClient()
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseURL)
                .client(httpClient)
                .build()

            return retrofit.create(UserAccountService::class.java)
        }

        fun createList(): ListService {
            val httpClient = httpClient()
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseURL)
                .client(httpClient)
                .build()

            return retrofit.create(ListService::class.java)
        }

        fun createItem(): ItemService {
            val httpClient = httpClient()
            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(baseURL)
                .client(httpClient)
                .build()

            return retrofit.create(ItemService::class.java)
        }
    }
}