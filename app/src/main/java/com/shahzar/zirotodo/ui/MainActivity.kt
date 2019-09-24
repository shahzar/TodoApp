package com.shahzar.zirotodo.ui

import android.os.Bundle
import com.shahzar.zirotodo.R
import com.shahzar.zirotodo.ui.base.BaseActivity
import com.shahzar.zirotodo.ui.list.ListFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        NavMgr.instance.pushFragment(this, ListFragment.newInstance())
    }

    override fun onBackPressed() {

        if (!NavMgr.instance.hasItemsInBackstack(this)) {
            finish()
            return
        }

        super.onBackPressed()
    }

}
