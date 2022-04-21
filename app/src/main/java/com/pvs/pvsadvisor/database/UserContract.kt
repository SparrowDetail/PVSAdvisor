package com.pvs.pvsadvisor.database

import android.provider.BaseColumns

object UserContract : BaseColumns {
    const val TABLE_NAME = "USER"
    const val PK_USERID = "userID"
    const val KEY_EMAIL = "email"
    const val KEY_PASSWORD = "password"
    const val KEY_FIRST_NAME = "firstName"
    const val KEY_LAST_NAME = "lastName"
    const val KEY_STATUS = "status"
}