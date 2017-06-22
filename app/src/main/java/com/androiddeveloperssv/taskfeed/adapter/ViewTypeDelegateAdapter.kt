package com.androiddeveloperssv.taskfeed.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Created by rodrigomiranda on 6/22/17.
 */
interface ViewTypeDelegateAdapter {

    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)

}