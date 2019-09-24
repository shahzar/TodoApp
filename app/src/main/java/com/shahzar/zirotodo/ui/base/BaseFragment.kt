package com.shahzar.zirotodo.ui.base

import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.shahzar.zirotodo.ui.NavMgr

open class BaseFragment: Fragment() {

    fun goBack() {
        NavMgr.instance.pop(activity)
    }

    fun showError(view: View, msg: String) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show()
    }

    fun showMessage(view: View, msg: String) {
        Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show()
    }
}