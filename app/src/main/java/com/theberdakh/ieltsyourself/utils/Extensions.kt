package com.theberdakh.ieltsyourself.utils

import android.widget.Toast


fun makeToast(message: String, length: Int?=null) {
    Toast.makeText(App.instance, message, length ?: Toast.LENGTH_SHORT).show()
}

