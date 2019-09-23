package com.shahzar.zirotodo.data

import com.shahzar.zirotodo.data.model.ItemModel

class DataManager() {

    companion object {
        val instance = DataManager()
    }

    private var items : MutableList<ItemModel> = mutableListOf()

    init {
        items.add(ItemModel("Task 1", "Description of task 1"))
        items.add(ItemModel("Task 2", "Description of task 2"))
        items.add(ItemModel("Task 3", "Description of task 3"))
        items.add(ItemModel("Task 4", "Description of task 4"))
        items.add(ItemModel("Task 5", "Description of task 5"))
        items.add(ItemModel("Task 6", "Description of task 6"))
        items.add(ItemModel("Task 7", "Description of task 7"))
        items.add(ItemModel("Task 8", "Description of task 8"))
        items.add(ItemModel("Task 9", "Description of task 9"))
        items.add(ItemModel("Task 10", "Description of task 10"))
        items.add(ItemModel("Task 11", "Description of task 11"))
        items.add(ItemModel("Task 12", "Description of task 12"))
        items.add(ItemModel("Task 13", "Description of task 13"))
        items.add(ItemModel("Task 14", "Description of task 14"))
    }

    fun addItems(itemModel: ItemModel) {
        items.add(itemModel)
    }

    fun getAllItems() : List<ItemModel>{
        return items;
    }

}