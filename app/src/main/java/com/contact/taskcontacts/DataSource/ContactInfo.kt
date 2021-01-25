package com.contact.taskcontacts.DataSource

import androidx.room.ColumnInfo


class ContactInfo{

    @ColumnInfo(name = "contactId")
    var contactId:String=""

    @ColumnInfo(name = "stagingId")
    var stagingId:String=""

    @ColumnInfo(name = "status")
    var status:String=""

    @ColumnInfo(name = "acc_context")
    var context:String=""

    @ColumnInfo(name = "userID")
    var userID:String=""

}
