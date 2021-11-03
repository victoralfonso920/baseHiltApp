@file:Suppress(
    "RECEIVER_NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS",
    "NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS"
)

package com.example.basehiltdi.ui.presentation.utils.extensions


import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*


fun dateStart(day: Int, month: Int, year: Int): Calendar {
    val selectedDate = "$day/$month/$year"
    val myFormat = "dd/MM/yyyy" // mention the format you need
    val esLocale = Locale("es", "ES")
    val date: Date = SimpleDateFormat(myFormat, esLocale).parse(selectedDate)
    val calendar = Calendar.getInstance()
    calendar.time = date
    return calendar
}

fun dateEnd(day: Int, month: Int, year: Int): Calendar {
    val selectedDate = "$day/$month/$year"
    val myFormat = "dd/MM/yyyy" // mention the format you need
    val esLocale = Locale("es", "ES")
    val date: Date = SimpleDateFormat(myFormat, esLocale).parse(selectedDate)
    val calendar = Calendar.getInstance()
    calendar.time = date
    return calendar
}

fun dateFormat(year: Int, month: Int, day: Int): String {
    val date = Calendar.getInstance()
    date.set(Calendar.YEAR, year)
    date.set(Calendar.MONTH, month)
    date.set(Calendar.DAY_OF_MONTH, day)
    val fechaSelect = date.time

    val myFormat = "dd MMM yyyy" // mention the format you need
    val esLocale = Locale("es", "ES")
    val sdf = SimpleDateFormat(myFormat, esLocale)

    return sdf.format(fechaSelect).replace(".", "").toUpperCase()
}

fun firstDateFormat(year: Int, month: Int, day: Int): String {
    val date = Calendar.getInstance()
    date.set(Calendar.YEAR, year)
    date.set(Calendar.MONTH, month - 1)
    date.set(Calendar.DAY_OF_MONTH, day)
    val fechaSelect = date.time

    val myFormat = "EEEE dd MMMM" // mention the format you need
    val esLocale = Locale("es", "ES")
    val sdf = SimpleDateFormat(myFormat, esLocale)

    return sdf.format(fechaSelect).replace(".", "")
}

fun dayFormat(year: Int, month: Int, day: Int): String {
    val date = Calendar.getInstance()
    date.set(Calendar.YEAR, year)
    date.set(Calendar.MONTH, month - 1)
    date.set(Calendar.DAY_OF_MONTH, day)
    val fechaSelect = date.time

    val myFormat = "EEEE" // mention the format you need
    val esLocale = Locale("es", "ES")
    val sdf = SimpleDateFormat(myFormat, esLocale)

    return sdf.format(fechaSelect).replace(".", "")
}

fun timeFormat(hour: Int, minute: Int): String {
    val df: DateFormat = SimpleDateFormat("h:mm a", Locale.US)
    val calendarStart = Calendar.getInstance()
    calendarStart.set(
        Calendar.HOUR_OF_DAY,
        hour
    )
    calendarStart.set(
        Calendar.MINUTE,
        minute
    )
    return df.format(calendarStart.time)
}

fun hourFormat(hour: Int, minute: Int): String {
    val df: DateFormat = SimpleDateFormat("h:mma", Locale.US)
    val calendarStart = Calendar.getInstance()
    calendarStart.set(
        Calendar.HOUR_OF_DAY,
        hour
    )
    calendarStart.set(
        Calendar.MINUTE,
        minute
    )
    return df.format(calendarStart.time).replace(":00", "")
}

fun addDate(day: Int, month: Int, year: Int): Calendar {
    val selectedDate = "$day/$month/$year"
    val myFormat = "dd/MM/yyyy" // mention the format you need
    val esLocale = Locale("es", "ES")
    val date: Date = SimpleDateFormat(myFormat, esLocale).parse(selectedDate)
    val calendar = Calendar.getInstance()
    calendar.time = date
    return calendar
}

fun dateDisable(fecha: Date): Calendar {
    // formatted
    val myFormat = "dd/MM/yyyy"
    val esLocale = Locale("es", "ES")

    val sdf = SimpleDateFormat(myFormat, esLocale)
    val selectedDate = sdf.format(fecha)
    val date: Date = sdf.parse(selectedDate)

    val calendar = Calendar.getInstance()
    calendar.time = date
    return calendar
}

fun dateRange(startDate: Date, endDate: Date): ArrayList<Date> {

    val calendarStart = Calendar.getInstance()
    calendarStart.time = startDate
    val calendarEnd = Calendar.getInstance()
    calendarEnd.time = endDate

    // Lista donde se irán almacenando las fechas
    val listaFechas: ArrayList<Date> = ArrayList()
    // Bucle para recorrer el intervalo, en cada paso se le suma un día.
    while (!calendarStart.after(calendarEnd)) {
        listaFechas.add(calendarStart.time)
        calendarStart.add(Calendar.DAY_OF_MONTH, 1)
    }
    return listaFechas
}

fun dateString(fecha: Date): String {
    // formatted
    val myFormat = "dd/MM/yyyy"
    val esLocale = Locale("es", "ES")
    val sdf = SimpleDateFormat(myFormat, esLocale)
    return sdf.format(fecha)
}

fun calculateTime(seconds: Int): String {
    val hour: Int = seconds / 3600
    val minute: Int = (seconds - hour * 3600) / 60
    val days = (seconds / 86400)
    return when {
        seconds > 86400 -> {
            "$days dias"
        }
        seconds == 86400 -> {
            "$days dia"
        }
        seconds > 3600 -> {
            if (minute == 0) {
                "$hour horas"
            } else {
                "$hour:${minuteAdd(minute)} horas"
            }
        }
        seconds == 3600 -> {
            "$hour hora"
        }
        else -> {
            "$minute minutos"
        }
    }
}

fun minuteAdd(minute: Int): String {
    return if (minute < 10) {
        "0$minute"
    } else {
        "$minute"
    }
}

fun daySecond(seconds: Long): String {
    val millis = (seconds * 1000L)
    val date = Date(millis)

    val myFormat = "dd" // mention the format you need
    val esLocale = Locale("es", "ES")
    val sdf = SimpleDateFormat(myFormat, esLocale)
    val newDate = sdf.format(date.time).replace(".", "").toUpperCase()
    return newDate
}

fun monthSecond(seconds: Long): String {
    val millis = (seconds * 1000L)
    val date = Date(millis)

    val myFormat = "MMMM" // mention the format you need
    val esLocale = Locale("es", "ES")
    val sdf = SimpleDateFormat(myFormat, esLocale)
    val newDate = sdf.format(date.time).replace(".", "").toUpperCase()
    return newDate
}

fun dateDayNew(formatted: String?): String {
    return try {
        val date = Date(formatted)
        val newFormat = "d" // mention the format you need
        val sdf = SimpleDateFormat(newFormat, Locale.getDefault())
        // sdf.timeZone = TimeZone.getTimeZone("UTC")
        sdf.format(date.time).replace(".", "")
    } catch (e: Exception) {
        ""
    }
}

fun dateMonthNew(formatted: String?): String {
    return try {
        val date = Date(formatted)
        val newFormat = "MMMM" // mention the format you need
        val esLocale = Locale("es", "ES")
        val sdf = SimpleDateFormat(newFormat, esLocale)
        // sdf.timeZone = TimeZone.getTimeZone("UTC")
        sdf.format(date.time).replace(".", "")
    } catch (e: Exception) {
        ""
    }
}

fun dateStringNew(formatted: String?): String {
    return try {
        val date = Date(formatted)
        val newFormat = "dd/MM/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(newFormat, Locale.getDefault())
        // sdf.timeZone = TimeZone.getTimeZone("UTC")
        sdf.format(date.time).replace(".", "")
    } catch (e: Exception) {
        ""
    }
}

fun timeFormatNew(formatted: String?): String {
    return try {
        val date = Date(formatted)
        val sdf = SimpleDateFormat("h:mm a", Locale.US)
        // sdf.timeZone = TimeZone.getTimeZone("UTC")
        sdf.format(date.time).replace(".", "")
    } catch (e: Exception) {
        ""
    }
}

fun hourFormatNew(formatted: String?): String {
    return try {
        val date = Date(formatted)
        val sdf = SimpleDateFormat("h:mma", Locale.US)
        // sdf.timeZone = TimeZone.getTimeZone("UTC")
        sdf.format(date.time).replace(":00", "")
    } catch (e: Exception) {
        ""
    }
}

fun firstDateFormatNew(formatted: String?): String {
    return try {
        val date = Date(formatted)
        val newFormat = "EEEE dd MMMM" // mention the format you need
        val esLocale = Locale("es", "ES")
        val sdf = SimpleDateFormat(newFormat, esLocale)
        // sdf.timeZone = TimeZone.getTimeZone("UTC")
        sdf.format(date.time).replace(".", "")
    } catch (e: Exception) {
        ""
    }
}

fun dayFormatNew(formatted: String?): String {
    return try {
        val date = Date(formatted)
        val newFormat = "EEEE" // mention the format you need
        val esLocale = Locale("es", "ES")
        val sdf = SimpleDateFormat(newFormat, esLocale)
        // sdf.timeZone = TimeZone.getTimeZone("UTC")
        sdf.format(date.time).replace(".", "")
    } catch (e: Exception) {
        ""
    }
}

fun dateStartNew(formatted: String?): Calendar {
    val calendar = Calendar.getInstance()
    return try {
        val date = Date(formatted)
        val newFormat = "dd/MM/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(newFormat, Locale.getDefault())
        val selectedDate = sdf.format(date.time).replace(".", "")
        val newDate: Date = SimpleDateFormat(newFormat, Locale.getDefault()).parse(selectedDate)
        calendar.time = newDate
        calendar
    } catch (e: Exception) {
        calendar
    }
}

fun dateEndNew(formatted: String?): Calendar {
    val calendar = Calendar.getInstance()
    return try {
        val date = Date(formatted)
        val newFormat = "dd/MM/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(newFormat, Locale.getDefault())
        val selectedDate = sdf.format(date.time).replace(".", "")
        val newDate: Date = SimpleDateFormat(newFormat, Locale.getDefault()).parse(selectedDate)
        calendar.time = newDate
        calendar
    } catch (e: Exception) {
        calendar
    }
}

fun addDateNew(formatted: String?): Calendar {
    val calendar = Calendar.getInstance()
    return try {
        val date = Date(formatted)
        val newFormat = "dd/MM/yyyy" // mention the format you need
        val sdf = SimpleDateFormat(newFormat, Locale.getDefault())
        val selectedDate = sdf.format(date.time).replace(".", "")
        val newDate: Date = SimpleDateFormat(newFormat, Locale.getDefault()).parse(selectedDate)
        calendar.time = newDate
        calendar
    } catch (e: Exception) {
        calendar
    }
}
