package com.shahzar.zirotodo.ui.list

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager

import com.shahzar.zirotodo.R
import com.shahzar.zirotodo.ui.NavMgr
import com.shahzar.zirotodo.ui.base.BaseFragment
import com.shahzar.zirotodo.ui.create.CreateFragment
import kotlinx.android.synthetic.main.list_fragment.*
import kotlinx.android.synthetic.main.list_fragment.view.*

class ListFragment : BaseFragment() {

    private lateinit var viewModel: ListViewModel
    lateinit var rootView: View

    companion object {
        fun newInstance() = ListFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rootView = inflater.inflate(R.layout.list_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)

        initView()

        return rootView
    }

    private fun initView() {
        viewModel.loadItems()

        // Setup Recycler View
        rootView.list.layoutManager = LinearLayoutManager(context)
        val listAdapter = ListAdapter()
        rootView.list.adapter = listAdapter

        // Handle click
        rootView.fab.setOnClickListener {
            NavMgr.instance.pushFragment(activity, CreateFragment.newInstance())
        }

        listAdapter.onDeleteClick = {
            viewModel.deleteItem(it)
            listAdapter.remove(it)
        }

        listAdapter.onEditClick = {
            NavMgr.instance.pushFragment(activity, CreateFragment.newInstance(it))
        }

        // Observe ViewModels
        viewModel.items.observe(viewLifecycleOwner, Observer { listAdapter.add(it) })
        viewModel.onitemDelete.observe(viewLifecycleOwner, Observer { showMessage(rootView, getString(
                    R.string.msg_item_deleted) + " ${it.title}") })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
