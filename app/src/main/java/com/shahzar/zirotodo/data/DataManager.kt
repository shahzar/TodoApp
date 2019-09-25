package com.shahzar.zirotodo.data

import com.shahzar.zirotodo.data.model.ItemModel
import com.shahzar.zirotodo.data.repository.InMemoryRepository

class DataManager(val repository: InMemoryRepository) {

    companion object {
        val instance = DataManager(InMemoryRepository())
    }

    fun addItems(itemModel: ItemModel) {
        repository.addItems(itemModel)
    }

    fun updateItems(itemModel: ItemModel) {
        repository.updateItems(itemModel)
    }

    fun getAllItems() : List<ItemModel>{
        return repository.getAllItems()
    }

    fun removeItem(itemModel: ItemModel) {
        repository.removeItem(itemModel)
    }

}