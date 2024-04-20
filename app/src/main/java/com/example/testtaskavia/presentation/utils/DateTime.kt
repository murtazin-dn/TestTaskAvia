package com.example.testtaskavia.presentation.utils

import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

fun getCurrentDateFormatted(): String {
    val calendar = Calendar.getInstance()
    return formatDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), )
}
fun formatDate(year: Int, month: Int, day: Int): String {
    val calendar = Calendar.getInstance()
    calendar.set(year, month, day)
    val dateFormat = SimpleDateFormat("dd MMM, EE", Locale.getDefault())
    return dateFormat.format(calendar.time)
}