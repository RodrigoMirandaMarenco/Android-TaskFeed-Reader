package com.androiddeveloperssv.taskfeed.util

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by rodrigomiranda on 6/21/17.
 * Extension Functions
 * TODO: Investigate a pattern or architecture that dictates how to organize this functions (esto se puede descontrolar)
 */
fun ViewGroup.inflate(layoutId: Int, attachToRoot : Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, attachToRoot)
}

fun AppCompatActivity.changeFragment(fragment : Fragment, containerId : Int, clearBackStack : Boolean = false) {
    val supportFragmentManager = supportFragmentManager
    val fragmentTransaction = supportFragmentManager.beginTransaction()

    if (clearBackStack && supportFragmentManager.backStackEntryCount > 0) {
        supportFragmentManager.popBackStack(supportFragmentManager.getBackStackEntryAt(0).id, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    fragmentTransaction.replace(containerId, fragment)
    fragmentTransaction.addToBackStack(null)
    fragmentTransaction.commit()
}

fun ImageView.loadUrl(imageUrl: String) {
    Picasso.with(context)
            .load(imageUrl)
            .into(this)
}