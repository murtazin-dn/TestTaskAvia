package com.example.data.network.utils

fun formatNumberWithSpaces(number: Int): String {
    val numberString = number.toString()
    val reversed = numberString.reversed()
    val stringBuilder = StringBuilder()

    for (i in reversed.indices) {
        if (i != 0 && i % 3 == 0) {
            stringBuilder.append(" ")
        }
        stringBuilder.append(reversed[i])
    }

    return stringBuilder.reverse().toString()
}