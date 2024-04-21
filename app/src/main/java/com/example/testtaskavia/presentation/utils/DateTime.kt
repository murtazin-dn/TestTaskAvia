package com.example.testtaskavia.presentation.utils

import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Locale
import kotlin.math.round
import kotlin.math.roundToLong

fun getCurrentDateFormatted(): String {
    val calendar = Calendar.getInstance()
    return formatDate(calendar)
}
fun formatDate(calendar: Calendar): String {
    val dateFormat = SimpleDateFormat("dd MMM, EE", Locale.getDefault())
    return dateFormat.format(calendar.time)
}

fun formatDate2(dateString: String): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val outputFormat = SimpleDateFormat("d MMMM", Locale("ru"))
    val date = inputFormat.parse(dateString)
    return outputFormat.format(date)
}

fun calendarToDateIso(calendar: Calendar): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    return dateFormat.format(calendar.time)
}

fun formatDepartureArrivalTime(time: String): String {
    val inputFormat  = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val outputFormat  = SimpleDateFormat("HH:mm", Locale.getDefault())
    val dateTime = inputFormat.parse(time)
    return outputFormat .format(dateTime)
}

fun calculateTimeDifference(startDate: String, endDate: String): String {
    val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
    val startDateFormatted = dateFormat.parse(startDate)
    val endDateFormatted = dateFormat.parse(endDate)

    val diffInMillis = endDateFormatted.time - startDateFormatted.time
    val diffInHalfHours = diffInMillis.toDouble() / (30 * 60 * 1000)

    val roundedDiff = round(diffInHalfHours * 2) / 2
    return if (roundedDiff % 1 == 0.0) {
        roundedDiff.toInt().toString()
    } else {
        roundedDiff.toString()
    }
}