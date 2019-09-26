package com.shahzar.zirotodo.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.shahzar.zirotodo.data.DataManager
import com.shahzar.zirotodo.data.model.ItemModel
import com.shahzar.zirotodo.data.repository.InMemoryRepository
import com.shahzar.zirotodo.ui.list.ListViewModel
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.runners.JUnit4


@RunWith(JUnit4::class)
class ListViewModelTest {

    @Rule @JvmField
    val rule = InstantTaskExecutorRule()
    var viewModel: ListViewModel? = null

    private lateinit var dataManager: DataManager

    private val sampleModel1 = ItemModel(id="1",title="Task 1", description = "Description of task 1")
    private val sampleModel2 = ItemModel(id="2",title="Task 2", description = "Description of task 2")

    @Mock
    lateinit var itemsObserver: Observer<List<ItemModel>>

    @Mock
    lateinit var deleteObserver: Observer<ItemModel>

    @Mock
    lateinit var doneObserver: Observer<ItemModel>


    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this);
        val inMemoryRepository = InMemoryRepository()
        inMemoryRepository.addItems(sampleModel1)
        inMemoryRepository.addItems(sampleModel2)
        dataManager = DataManager(inMemoryRepository)

        viewModel = ListViewModel()
        viewModel?.items?.observeForever(itemsObserver)
        viewModel?.onitemDelete?.observeForever(deleteObserver)
        viewModel?.onitemCompleted?.observeForever(doneObserver)
    }

    @Test
    fun testDataManager() {
        var allItems = dataManager.getAllItems()
        assert(allItems.contains(sampleModel1))
        assert(allItems.contains(sampleModel2))
    }

    @Test
    fun testViewModel() {
        assertTrue(viewModel!!.items.hasActiveObservers())
    }

    @Test
    fun testLoadData() {
        viewModel?.loadItems()
        Mockito.verify(itemsObserver).onChanged(viewModel!!.items.value)
    }

    @Test
    fun testDeleteItem() {
        viewModel?.deleteItem(sampleModel1)
        Mockito.verify(deleteObserver).onChanged(sampleModel1)
    }

    @Test
    fun testTaskDone() {
        viewModel?.taskDone(sampleModel2, true)
        Mockito.verify(doneObserver).onChanged(sampleModel2)
    }

}