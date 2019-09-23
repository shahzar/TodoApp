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

        supportFragmentManager
            .beginTransaction()
            .addToBackStack("")
            .replace(R.id.content_frag, ListFragment.newInstance()).commit()
    }

}
