package com.contact.taskcontacts.DataSource

import com.contact.taskcontacts.DataBase.Entity.Account
import com.contact.taskcontacts.DataBase.Entity.Contact
import com.contact.taskcontacts.DataBase.Entity.Extension


object DataSource {


    fun getContacts():ArrayList<Contact>{

        val list = arrayListOf<Contact>()
        list.add(Contact(_id = 2,contactId = "48f3",stagingId = "1196"))
        list.add(Contact(_id = 3,contactId = "3e47",stagingId = "f1fe"))
        list.add(Contact(_id = 4,contactId = "2Cac",stagingId = "036e"))
        return list
    }

    fun getAccounts():ArrayList<Account>{

        val list = arrayListOf<Account>()
        list.add(Account(status = 1,userID = "test_one@gmail.com",context = "Gmail"))
        list.add(Account(status = 0,userID = "test_two@gmail.com",context = "Gmail1"))
        return list
    }

    fun getExtensions():ArrayList<Extension>{

        val list = arrayListOf<Extension>()
        list.add(Extension(phoneContactId = 2,context = "Gmail"))
        list.add(Extension(phoneContactId = 3,context = "Gmail"))
        list.add(Extension(phoneContactId = 4,context = "Gmail1"))
        return list
    }
}