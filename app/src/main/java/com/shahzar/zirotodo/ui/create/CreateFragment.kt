package com.shahzar.zirotodo.ui.create

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar

import com.shahzar.zirotodo.R
import com.shahzar.zirotodo.data.model.ItemModel
import com.shahzar.zirotodo.ui.base.BaseFragment
import com.shahzar.zirotodo.ui.list.ListAdapter
import kotlinx.android.synthetic.main.create_fragment.view.*
import kotlinx.android.synthetic.main.list_fragment.view.*

class CreateFragment : BaseFragment() {

    private lateinit var viewModel: CreateViewModel
    lateinit var rootView: View

    companion object {
        var itemModel: ItemModel? = null
        var isEditMode: Boolean = false

        fun newInstance() = CreateFragment()
        fun newInstance(itemModel: ItemModel) : CreateFragment {
            this.itemModel = itemModel
            isEditMode = true
            return CreateFragment()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.create_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(CreateViewModel::class.java)

        initView()

        return rootView
    }

    private fun initView() {

        populateIfEditMode()

        // Handle click
        rootView.submit.setOnClickListener {
            if (!isEditMode) {
                val item = ItemModel(rootView.title.text.toString(), rootView.description.text.toString())
                viewModel.addItem(item)
            } else {
                itemModel?.apply {
                    title = rootView.title.text.toString()
                    description = rootView.description.text.toString()
                    viewModel.editItem(this)
                }
            }
        }

        // Observe ViewModels
        viewModel.submit.observe(viewLifecycleOwner, Observer {
            goBack()
        })

        viewModel.showError.observe(viewLifecycleOwner, Observer { showError(rootView, it) })

    }

    private fun populateIfEditMode() {
        if (!isEditMode || itemModel == null) return

        rootView.title.setText(itemModel?.title)
        rootView.description.setText(itemModel?.description)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
