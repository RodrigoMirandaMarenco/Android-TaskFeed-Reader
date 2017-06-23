package com.androiddeveloperssv.taskfeed.fragment

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androiddeveloperssv.taskfeed.R
import com.androiddeveloperssv.taskfeed.adapter.TaskAdapter
import com.androiddeveloperssv.taskfeed.network.TasksManager
import com.androiddeveloperssv.taskfeed.util.inflate
import kotlinx.android.synthetic.main.task_list_fragment.*
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by rodrigomiranda on 6/21/17.
 */
class TaskListFragment : BaseFragment() {

    private val tasksManager by lazy { TasksManager() }

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
            requestTasks()
        }

    }

    private fun requestTasks() {
        val subscription = tasksManager.getTasks()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                { retrievedTasks ->
                    (recyclerView_task_list.adapter as TaskAdapter).addTaskItems(retrievedTasks)
                },
                { error ->
                    Snackbar.make(recyclerView_task_list, error.message ?: "Error", Snackbar.LENGTH_SHORT).show()
                }

        )
        subscriptions.add(subscription)
    }

}