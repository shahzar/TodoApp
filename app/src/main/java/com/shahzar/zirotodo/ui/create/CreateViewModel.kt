package com.shahzar.zirotodo.   ui.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shahzar.zirotodo.data.DataManager
import com.shahzar.zirotodo.data.model.ItemModel

class CreateViewModel : ViewModel() {

    private val dataManager: DataManager = DataManager()

    val items = MutableLiveData<List<ItemModel>>()
    val submit = MutableLiveData<Boolean>()
    val showError = MutableLiveData<String>()

    fun addItem(item:ItemModel) {

        if (item.title == "") {
            showError.value = "Please enter a title"
            return
        }

        DataManager.instance.addItems(item)
        submit.value = true
    }

}
