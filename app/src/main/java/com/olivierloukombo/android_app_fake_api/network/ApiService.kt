package com.olivierloukombo.android_app_fake_api.network

import com.olivierloukombo.android_app_fake_api.model.Comment
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("comments")
    suspend fun getComments(): List<Comment>

    companion object {
        var api: ApiService? = null
        private const val BASE_URL: String = "https://jsonplaceholder.typicode.com/"
        fun getInstance(): ApiService {
            if (api == null) {
                api = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiService::class.java)
            }
            return api!!
        }
    }
}