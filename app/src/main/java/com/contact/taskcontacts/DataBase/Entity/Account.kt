package com.contact.taskcontacts.DataBase.Entity

import androidx.room.*

@Entity
class Account (
    @PrimaryKey(autoGenerate = false)
    var userID:String,
    var status:Int,
    @ColumnInfo(name = "acc_context")
    var context:String
)