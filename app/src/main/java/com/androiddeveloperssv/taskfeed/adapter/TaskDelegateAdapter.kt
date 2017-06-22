package com.androiddeveloperssv.taskfeed.adapter

import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.androiddeveloperssv.taskfeed.R
import com.androiddeveloperssv.taskfeed.model.TaskItem
import com.androiddeveloperssv.taskfeed.util.inflate
import com.androiddeveloperssv.taskfeed.util.loadUrl
import kotlinx.android.synthetic.main.task_item_task.view.*

/**
 * Created by rodrigomiranda on 6/22/17.
 */
class TaskDelegateAdapter: ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as TaskItem)
    }

    class TurnsViewHolder(parent: ViewGroup): RecyclerView.ViewHolder(
            parent.inflate(R.layout.task_item_task)) {

        fun bind(item: TaskItem) = with(itemView){
            textViewName.text = item.name
            textViewDescription.text = item.description
            textViewStatus.text = if (item.done) itemView.context.getText(R.string.task_status_done) else itemView.context.getText(R.string.task_status_pending)
            textViewStatus.setTextColor(ContextCompat.getColor(itemView.context, if (item.done) R.color.colorStatusDone else R.color.colorStatusPending))
            imageViewLogo.loadUrl(item.imageUrl)
        }

    }

}