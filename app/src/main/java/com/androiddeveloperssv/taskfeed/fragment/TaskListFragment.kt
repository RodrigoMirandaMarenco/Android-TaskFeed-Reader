package com.androiddeveloperssv.taskfeed.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androiddeveloperssv.taskfeed.R
import com.androiddeveloperssv.taskfeed.adapter.TaskAdapter
import com.androiddeveloperssv.taskfeed.model.TaskItem
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
        if (recyclerView_task_list.adapter == null) {
            recyclerView_task_list.adapter = TaskAdapter()
        }

        if (savedInstanceState == null) {
            var taskList = mutableListOf<TaskItem>()
            for (i in 1..10) {
                var taskItem = TaskItem()
                taskItem.name = taskItem.name + " " + i
                taskList.add(taskItem)
            }
            (recyclerView_task_list.adapter as TaskAdapter).addItems(taskList)
        }

    }

}