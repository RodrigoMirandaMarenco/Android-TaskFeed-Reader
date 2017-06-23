package com.androiddeveloperssv.taskfeed.network

import com.androiddeveloperssv.taskfeed.model.TaskItem
import com.androiddeveloperssv.taskfeed.model.Tasks
import rx.Observable


/**
 * Created by rodrigomiranda on 6/22/17.
 */
class TasksManager(private val api: TaskApiClient = TaskApiClient()) {

    fun getTasks(): Observable<Tasks> {
        return Observable.create {
            
            subscriber ->

            val callResponse = api.getTaskFeed()
            val response = callResponse.execute()
            if (response.isSuccessful) {
                val taskList = response.body() ?: ArrayList<TaskItem>()
                subscriber.onNext(Tasks(taskList))
            } else {
                subscriber.onError(Throwable("Network Error"))
            }

        }

    }

}