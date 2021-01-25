package com.contact.taskcontacts.DataBase.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey




@Entity
class Contact(
    @PrimaryKey(autoGenerate = false)
    var _id: Int,
    var contactId:String,
    var stagingId:String
)