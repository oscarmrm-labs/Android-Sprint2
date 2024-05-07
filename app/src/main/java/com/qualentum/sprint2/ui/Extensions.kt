package com.qualentum.sprint2.ui

import android.widget.EditText

fun EditText.toDouble(et: EditText?): Double{
    return et?.text.toString().toDouble()
}