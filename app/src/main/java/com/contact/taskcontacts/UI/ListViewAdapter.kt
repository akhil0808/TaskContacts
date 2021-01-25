package com.contact.taskcontacts.UI

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.databinding.DataBindingUtil
import com.contact.taskcontacts.DataSource.ContactInfo
import com.contact.taskcontacts.R
import com.contact.taskcontacts.UI.OnItemClick
import com.contact.taskcontacts.databinding.ItemSearchListBinding


class ListViewAdapter(private var list: List<ContactInfo>, private var clicker : OnItemClick) : BaseAdapter() {




    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): ContactInfo {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var rootView =view
            val binding =  DataBindingUtil.inflate<ItemSearchListBinding>(
                LayoutInflater.from(parent.context), R.layout.item_search_list, parent, false
            )

            binding.title.text = list[position].contactId
            binding.title.setOnClickListener {
                clicker.onItemClicked(list[position])
            }
            rootView = binding.root

        return rootView
    }



}