package com.contact.taskcontacts.UI

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.contact.taskcontacts.BaseActivity
import com.contact.taskcontacts.ContactTask
import com.contact.taskcontacts.DataSource.ContactInfo
import com.contact.taskcontacts.DataSource.DataSource

import com.contact.taskcontacts.R
import com.contact.taskcontacts.ViewModel.ContactViewModel
import com.contact.taskcontacts.ViewModel.ViewModelFactory
import com.contact.taskcontacts.databinding.ActivityMainBinding



class MainActivity : BaseActivity<ActivityMainBinding>(), OnItemClick {



    override val layoutResId: Int
        get() = R.layout.activity_main
    private lateinit var viewModel: ContactViewModel
    private lateinit var mainBinding: ActivityMainBinding
    private val searchList  = arrayListOf<ContactInfo>()
    private val adapter = ListViewAdapter(searchList,this)


    override fun getToolBar(binding: ActivityMainBinding): Toolbar? {
       return null
     }


    override fun onActivityReady(instance: Bundle?, binding: ActivityMainBinding) {

        // this should be done by dependency injection

        val database = ContactTask.getDatabase()
        val viewModelFactory = ViewModelFactory(database.contactDao())
        viewModel = ViewModelProviders.of(this@MainActivity, viewModelFactory)
            .get(ContactViewModel::class.java)

        mainBinding = binding
        // filling database
        viewModel.insetContacts(DataSource.getContacts())
        viewModel.insetExtensions(DataSource.getExtensions())
        viewModel.insetAccounts(DataSource.getAccounts())

        binding.searchView.addTextChangedListener(object:TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
              if (s.toString().isNotEmpty()){
                  search(s.toString())
              }else{
                  clearList()
              }
            }
        })

        mainBinding.listView.adapter = adapter

    }



    private fun search(query:String){
        val value = viewModel.getContactInfoById(query)
        value.observe(this, Observer {
            if (it==null) return@Observer
                searchList.clear()
                searchList.addAll(it)
                adapter.notifyDataSetChanged()
        })
    }


    private fun clearList(){
        searchList.clear()
        adapter.notifyDataSetChanged()
    }


    override fun onItemClicked(model: ContactInfo) {
        clearList()
        mainBinding.searchView.setText("")
        mainBinding.contactId.text = model.contactId
        mainBinding.stagingId.text = model.stagingId
        mainBinding.context.text = model.context
        mainBinding.status.text = model.status
        mainBinding.userId.text = model.userID
    }

}
