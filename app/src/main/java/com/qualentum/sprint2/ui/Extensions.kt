package com.qualentum.sprint2.ui

import android.widget.EditText

fun EditText.toDouble(): Double{
    return this.text.toString().toDouble()
}