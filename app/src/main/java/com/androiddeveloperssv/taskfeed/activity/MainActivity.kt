package com.androiddeveloperssv.taskfeed.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.androiddeveloperssv.taskfeed.R
import com.androiddeveloperssv.taskfeed.fragment.TaskListFragment
import com.androiddeveloperssv.taskfeed.util.changeFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        if (savedInstanceState == null) {
            changeFragment(TaskListFragment(), R.id.activity_base_content)
        }
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 1) {
            supportFragmentManager.popBackStack()
        } else {
            finish()
        }
    }

}
