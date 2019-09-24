package com.shahzar.zirotodo.ui

import androidx.fragment.app.FragmentActivity
import com.shahzar.zirotodo.R
import com.shahzar.zirotodo.ui.base.BaseActivity
import com.shahzar.zirotodo.ui.base.BaseFragment

class NavMgr {

    companion object {
        val instance = NavMgr()
    }

    fun pushFragment(activity: FragmentActivity?, fragment: BaseFragment) {
        activity
            ?.supportFragmentManager
            ?.beginTransaction()
            ?.addToBackStack("")
            ?.replace(R.id.content_frag, fragment)
            ?.commit()

    }

    fun pop(activity: FragmentActivity?) {
        activity?.supportFragmentManager?.popBackStack()
    }

    fun hasItemsInBackstack(activity: FragmentActivity?) : Boolean{

        activity?.let {
            return it.supportFragmentManager.backStackEntryCount > 1
        }

        return false
    }

}