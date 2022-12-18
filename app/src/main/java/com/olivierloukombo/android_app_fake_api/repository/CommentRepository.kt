package com.olivierloukombo.android_app_fake_api.repository

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.olivierloukombo.android_app_fake_api.model.Comment
import com.olivierloukombo.android_app_fake_api.network.ApiService
import kotlinx.coroutines.coroutineScope
import javax.inject.Inject


class CommentRepository @Inject constructor(private val api: ApiService) {
    private var commentListResponse: List<Comment> by mutableStateOf(listOf())
    private var error: String by mutableStateOf("")
    suspend fun getComments(): List<Comment>{
        coroutineScope {
            try {
                val comments = api.getComments()
                commentListResponse = comments
            }catch (e: Exception){
                error = e.message.toString()
            }
        }

        return commentListResponse;
    }
}