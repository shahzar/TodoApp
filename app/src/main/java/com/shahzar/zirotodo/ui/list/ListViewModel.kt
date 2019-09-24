package com.shahzar.zirotodo.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shahzar.zirotodo.data.DataManager
import com.shahzar.zirotodo.data.model.ItemModel

class ListViewModel : ViewModel() {

    val items = MutableLiveData<List<ItemModel>>().apply { value = emptyList() }
    val onitemDelete = MutableLiveData<ItemModel>()
    val onitemCompleted = MutableLiveData<ItemModel>()

    fun loadItems() : LiveData<List<ItemModel>> {
        items.value = DataManager.instance.getAllItems()
        return items
    }

    fun deleteItem(item: ItemModel) {
        DataManager.instance.removeItem(item)
        onitemDelete.value = item
    }

    fun taskDone(item: ItemModel, done: Boolean) {
        item.completed = done
        DataManager.instance.updateItems(item)
        onitemCompleted.value = item
    }

}
