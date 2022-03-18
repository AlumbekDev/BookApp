package com.example.mov.presentation.ui.fragments

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mov.data.client.ServerClient
import com.example.mov.domain.models.LanguageModel

class MovViewModel  : ViewModel() {
    val description = MutableLiveData<String>()

    fun getBooks(): List<LanguageModel> {
        return ServerClient().getBooks()
    }

    fun putDescription(text: String) {
        description.value = text
    }
}