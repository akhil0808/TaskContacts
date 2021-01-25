package com.contact.taskcontacts.DataBase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.contact.taskcontacts.DataBase.Dao.ContactDao
import com.contact.taskcontacts.DataBase.Entity.Account
import com.contact.taskcontacts.DataBase.Entity.Contact
import com.contact.taskcontacts.DataBase.Entity.Extension


@Database(
    entities = [Contact::class, Extension::class, Account::class],version = 1)
abstract class ContactBookDB : RoomDatabase() {

    abstract fun contactDao(): ContactDao


    companion object {
        @Volatile
        private var instance: ContactBookDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ContactBookDB::class.java, "contactBook.db"
            ).build()
    }
}