package com.contact.taskcontacts.ViewModel

import android.accounts.Account
import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.contact.taskcontacts.DataBase.Dao.ContactDao
import com.contact.taskcontacts.DataBase.Entity.Contact
import com.contact.taskcontacts.DataBase.Entity.Extension
import com.contact.taskcontacts.DataSource.ContactInfo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch





class ContactViewModel(private var contactDao: ContactDao):ViewModel() {


    fun insetContacts(contacts:List<Contact>){

        GlobalScope.launch(Dispatchers.IO) {
           contactDao.insertContacts(contacts)
        }
    }

    fun insetAccounts(accounts:List<com.contact.taskcontacts.DataBase.Entity.Account>){
        GlobalScope.launch(Dispatchers.IO) {
            contactDao.insertAccounts(accounts)
        }
    }

    fun insetExtensions(extensions:List<Extension>){
        GlobalScope.launch(Dispatchers.IO) {
           contactDao.insertExtensions(extensions)
        }
    }

    fun getContactInfoById(contactId:String):LiveData<List<ContactInfo>>{
        val data = MediatorLiveData<List<ContactInfo>>()

        GlobalScope.launch(Dispatchers.IO) {
            val savedData = contactDao.getContactInfoById(contactId)
            GlobalScope.launch(Dispatchers.Main) {
                data.addSource(savedData){
                    data.value = it
                    data.removeSource(savedData)
                }
            }
        }

       return data
    }

}