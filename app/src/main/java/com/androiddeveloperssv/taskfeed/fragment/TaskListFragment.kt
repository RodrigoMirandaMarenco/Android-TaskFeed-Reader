package com.androiddeveloperssv.taskfeed.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androiddeveloperssv.taskfeed.R
import com.androiddeveloperssv.taskfeed.util.inflate
import kotlinx.android.synthetic.main.task_list_fragment.*

/**
 * Created by rodrigomiranda on 6/21/17.
 */
class TaskListFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return container?.inflate(R.layout.task_list_fragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recyclerView_task_list.setHasFixedSize(true)
        recyclerView_task_list.layoutManager = LinearLayoutManager(context)
    }

}