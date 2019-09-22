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
import com.shahzar.zirotodo.ui.base.BaseFragment
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

        rootView.list.layoutManager = LinearLayoutManager(context)
        val listAdapter = ListAdapter()
        rootView.list.adapter = listAdapter

        viewModel.items.observe(viewLifecycleOwner, Observer {listAdapter.add(it) })

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
