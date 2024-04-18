package com.example.testtaskavia.presentation.utils.ext

import android.text.Editable

fun String.toEditable(): Editable{
    return Editable.Factory.getInstance().newEditable(this)
}