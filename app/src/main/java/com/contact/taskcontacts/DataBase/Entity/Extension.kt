package com.contact.taskcontacts.DataBase.Entity

import androidx.room.*

@Entity
class Extension (
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "phoneContactId")
    var phoneContactId: Int,
    @ColumnInfo(name = "ext_context")
    var context:String
)