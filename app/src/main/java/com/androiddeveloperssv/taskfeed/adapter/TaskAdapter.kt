package com.androiddeveloperssv.taskfeed.adapter

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.androiddeveloperssv.taskfeed.model.TaskItem

/**
 * Created by rodrigomiranda on 6/21/17.
 */
class TaskAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: ArrayList<ViewType>
    private var delegateAdapters = SparseArrayCompat<ViewTypeDelegateAdapter>()
    private val loadingItem = object : ViewType {
        override fun getViewType() = AdapterConstants.LOADING
    }

    init {
        delegateAdapters.put(AdapterConstants.LOADING, LoadingDelegateAdapter())
        delegateAdapters.put(AdapterConstants.TASK, TaskDelegateAdapter())
        items = ArrayList()
        items.add(loadingItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegateAdapters.get(viewType).onCreateViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        delegateAdapters.get(getItemViewType(position)).onBindViewHolder(holder, this.items[position])
    }

    override fun getItemViewType(position: Int) = items.get(position).getViewType()

    override fun getItemCount() = items.size

    fun addTaskItems(taskItems: List<TaskItem>) {
        val initPosition = items.size - 1
        items.removeAt(initPosition)
        notifyItemRemoved(initPosition)
        items.addAll(taskItems)
        items.add(loadingItem)
        notifyItemRangeChanged(initPosition, items.size + 1)
    }

    fun clearAndAddTaskItems(taskItems: List<TaskItem>) {
        items.clear()
        notifyItemRangeRemoved(0, if (items.lastIndex == -1) 0 else items.lastIndex)
        items.addAll(taskItems)
        items.add(loadingItem)
        notifyItemRangeInserted(0, taskItems.size + 1)
    }

    fun getTaskItems(): List<TaskItem> {
        return items.filter { it.getViewType() == AdapterConstants.TASK }
                .map { it as TaskItem }
    }

}

