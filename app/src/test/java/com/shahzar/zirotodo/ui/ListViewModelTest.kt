package com.shahzar.zirotodo.ui

import com.shahzar.zirotodo.data.DataManager
import com.shahzar.zirotodo.data.model.ItemModel
import com.shahzar.zirotodo.data.repository.InMemoryRepository
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class ListViewModelTest {

    private lateinit var dataManager: DataManager

    private val sampleModel1 = ItemModel(id="1",title="Task 1", description = "Description of task 1")
    private val sampleModel2 = ItemModel(id="2",title="Task 2", description = "Description of task 2")

    @Before
    fun setup() {
        val inMemoryRepository = InMemoryRepository()
        inMemoryRepository.addItems(sampleModel1)
        inMemoryRepository.addItems(sampleModel2)
        dataManager = DataManager(inMemoryRepository)
    }

    @Test
    fun testDataManager() {
        var allItems = dataManager.getAllItems()
        assert(allItems.contains(sampleModel1))
        assert(allItems.contains(sampleModel2))
    }
}