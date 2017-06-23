package com.androiddeveloperssv.taskfeed.network

import com.androiddeveloperssv.taskfeed.model.TaskItem
import rx.Observable


/**
 * Created by rodrigomiranda on 6/22/17.
 */
class TasksManager() {

    fun getTasks(): Observable<List<TaskItem>> {
        return Observable.create {
            
            subscriber ->

            val taskList = mutableListOf<TaskItem>()
            for (i in 1..10) {
                val taskItem = TaskItem()
                taskItem.name = taskItem.name + " " + i
                taskList.add(taskItem)
            }

            subscriber.onNext(taskList)

        }

    }

}