package com.olivierloukombo.android_app_fake_api.network

import com.olivierloukombo.android_app_fake_api.model.Comment
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface ApiService {
    @GET("comments")
    suspend fun getComments(): List<Comment>


    companion object {
        private var api: ApiService? = null
        private const val BASE_URL: String = "https://jsonplaceholder.typicode.com/"
        private val logger = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BASIC }

        private val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        fun getInstance(): ApiService {
            if (api == null) {
                api = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                   // .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(ApiService::class.java)
            }
            return api!!
        }
    }
}