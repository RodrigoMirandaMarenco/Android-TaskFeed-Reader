package com.androiddeveloperssv.taskfeed.network

import com.androiddeveloperssv.taskfeed.model.TaskItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by rodrigomiranda on 6/22/17.
 */
class TaskApiClient {

    private val taskApi: TaskApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://kotlin-todo.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        taskApi = retrofit.create(TaskApi::class.java)
    }

    fun getTaskFeed(): Call<List<TaskItem>> {
        return taskApi.getTaskFeed()
    }

}