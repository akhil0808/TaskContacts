package com.contact.taskcontacts

import android.app.Application
import com.contact.taskcontacts.DataBase.ContactBookDB

class ContactTask  : Application() {


    companion object {
        private lateinit var db: ContactBookDB
        fun getDatabase(): ContactBookDB {
            return db
        }

    }


    override fun onCreate() {
        super.onCreate()
        db = ContactBookDB(this)
    }
}