package com.androiddeveloperssv.taskfeed.model

import com.androiddeveloperssv.taskfeed.adapter.AdapterConstants
import com.androiddeveloperssv.taskfeed.adapter.ViewType

/**
 * Created by rodrigomiranda on 6/22/17.
 */
data class TaskItem(var id: Int = 0, var name: String = "Test Name", var description: String = "Test Description", var imageUrl: String = "", var done: Boolean = false): ViewType {
    override fun getViewType() = AdapterConstants.TASK
}