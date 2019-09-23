package com.shahzar.zirotodo.data

import com.shahzar.zirotodo.data.model.ItemModel

class DataManager() {

    companion object {
        val instance = DataManager()
    }

    private var items : MutableList<ItemModel> = mutableListOf()

    init {
        items.add(ItemModel(id="1",title="Task 1", description = "Description of task 1"))
        items.add(ItemModel(id="2",title="Task 2", description = "Description of task 2"))
        items.add(ItemModel(id="3",title="Task 3", description = "Description of task 3"))
        items.add(ItemModel(id="4",title="Task 4", description = "Description of task 4"))
        items.add(ItemModel(id="5",title="Task 5", description = "Description of task 5"))
        items.add(ItemModel(id="6",title="Task 6", description = "Description of task 6"))
        items.add(ItemModel(id="7",title="Task 7", description = "Description of task 7"))
        items.add(ItemModel(id="8",title="Task 8", description = "Description of task 8"))
        items.add(ItemModel(id="9",title="Task 9", description = "Description of task 9"))
        items.add(ItemModel(id="10",title="Task 10", description = "Description of task 10"))
        items.add(ItemModel(id="11",title="Task 11", description = "Description of task 11"))
        items.add(ItemModel(id="12",title="Task 12", description = "Description of task 12"))
        items.add(ItemModel(id="13",title="Task 13", description = "Description of task 13"))
        items.add(ItemModel(id="14",title="Task 14", description = "Description of task 14"))
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