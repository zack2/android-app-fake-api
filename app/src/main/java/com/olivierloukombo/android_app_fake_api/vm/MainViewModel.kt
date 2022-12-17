package com.olivierloukombo.android_app_fake_api.vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.olivierloukombo.android_app_fake_api.model.Comment
import com.olivierloukombo.android_app_fake_api.repository.CommentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: CommentRepository) : ViewModel() {

    private var commentListResponse: List<Comment> by mutableStateOf(listOf())

    fun getComments(): List<Comment> {
        viewModelScope.launch {
            val comments = repository.getComments()
            commentListResponse = comments
        }
        return commentListResponse;
    }
}
