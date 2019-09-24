package com.shahzar.zirotodo.data.repository

import com.shahzar.zirotodo.data.model.ItemModel

class InMemoryRepository {

    private var items : MutableList<ItemModel> = mutableListOf()

    init {
        items.add(ItemModel(id="1",title="Task 1", description = "Description of task 1"))
        items.add(ItemModel(id="2",title="Task 2", description = "Description of task 2"))
        items.add(ItemModel(id="3",title="Task 3", description = "Description of task 3"))
        items.add(ItemModel(id="4",title="Task 4", description = "Description of task 4"))
    }

    fun addItems(itemModel: ItemModel) {
        items.add(itemModel)
    }

    fun updateItems(itemModel: ItemModel) {
        items.find { it.id == itemModel.id }.apply {
            this?.title = itemModel.title
            this?.description = itemModel.description
        }
    }

    fun getAllItems() : List<ItemModel>{
        return items;
    }

    fun removeItem(itemModel: ItemModel) {
        items.remove(itemModel)
    }
}