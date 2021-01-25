package com.contact.taskcontacts

import android.os.Bundle
import android.view.MenuItem
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

abstract class BaseActivity<B : ViewDataBinding> : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        onPreCreated()
        super.onCreate(savedInstanceState)
        val binding: ViewDataBinding = DataBindingUtil.setContentView(this, layoutResId)
        setSupportActionBar(getToolBar(binding as B))
        onActivityReady(savedInstanceState, binding)
    }


    protected open fun onPreCreated() {}

    protected abstract fun onActivityReady(instance: Bundle?, binding: B)

    @get:LayoutRes
    protected abstract val layoutResId: Int


    protected abstract fun getToolBar(binding: B): Toolbar?

    fun enableBack() {
        supportActionBar?.let {
            it.setDisplayHomeAsUpEnabled(true)
            it.setDisplayShowHomeEnabled(true)
            it.setDisplayShowTitleEnabled(false)
        }


    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        if (item?.itemId == android.R.id.home) {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }



}