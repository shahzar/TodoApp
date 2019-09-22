package com.shahzar.zirotodo.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shahzar.zirotodo.data.DataManager
import com.shahzar.zirotodo.data.model.ItemModel

class ListViewModel : ViewModel() {

    private val dataManager: DataManager = DataManager()

    val items = MutableLiveData<List<ItemModel>>().apply { value = emptyList() }

    fun loadItems() : LiveData<List<ItemModel>> {
        items.value = dataManager.getAllItems()
        return items
    }

}
