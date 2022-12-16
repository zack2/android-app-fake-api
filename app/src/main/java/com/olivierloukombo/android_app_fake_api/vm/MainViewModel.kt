package com.olivierloukombo.android_app_fake_api.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olivierloukombo.android_app_fake_api.network.ApiService
import com.olivierloukombo.android_app_fake_api.model.Comment
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {

    var commentListResponse: List<Comment> by mutableStateOf(listOf())
    var error: String by mutableStateOf("")
    fun getComments(): List<Comment>{
        viewModelScope.launch {
            val api = ApiService.getInstance()
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