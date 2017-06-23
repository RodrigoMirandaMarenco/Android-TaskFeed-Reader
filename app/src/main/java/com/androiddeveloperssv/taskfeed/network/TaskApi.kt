package com.androiddeveloperssv.taskfeed.network

import com.androiddeveloperssv.taskfeed.model.TaskItem
import retrofit2.Call
import retrofit2.http.GET

/**
 * Created by rodrigomiranda on 6/22/17.
 */
interface TaskApi {

    @GET("/api/v1.0//tasks")
    fun getTaskFeed(): Call<List<TaskItem>>

}