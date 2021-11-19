package com.example.mvvmroom.sample_2

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel : ViewModel() {
    private val itemModel = MutableLiveData<List<Item>>()
    val items : LiveData<List<Item>> = itemModel

    init {
        itemModel.value = mutableListOf()
    }

    fun addItem(name : String) {
        if (name.isEmpty()) return

        val tmpItems = items.value?.toMutableList() ?: mutableListOf()
        tmpItems.add(Item(name))
        itemModel.value = tmpItems

        Log.v("CONSOLE", "items ${itemModel.value}")
    }

    fun deleteItem(name : String) {
        if (name.isEmpty()) return

        val tmpItems = items.value?.toMutableList() ?: mutableListOf()
        tmpItems.remove(Item(name))
        itemModel.value = tmpItems

        Log.v("CONSOLE", "items ${itemModel.value}")
    }
}