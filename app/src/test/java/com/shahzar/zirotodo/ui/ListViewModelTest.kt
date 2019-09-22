package com.shahzar.zirotodo.ui

import com.shahzar.zirotodo.data.DataManager
import org.junit.Test

import org.junit.Assert.*

class ListViewModelTest {

    private val dataManager: DataManager = DataManager()


    @Test
    fun getItems() {
        var allItems = dataManager.getAllItems()
        assert(allItems.size == 10)
    }
}