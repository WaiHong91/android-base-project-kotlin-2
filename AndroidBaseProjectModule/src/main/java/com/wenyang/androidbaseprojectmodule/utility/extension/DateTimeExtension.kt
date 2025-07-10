package com.wenyang.androidbaseprojectmodule.utility.extension

import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.joda.time.LocalDate
import org.joda.time.format.DateTimeFormat
import org.joda.time.format.DateTimeFormatter

/**
 * Created by wenyang on 12/12/17.
 */

fun DateTime.toStandardFormat(): String? {

    val dateTimeFormatter: DateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss")

    dateTimeFormatter.withZone(DateTimeZone.forID("Asia/Singapore"))

    return dateTimeFormatter.print(this)
}

fun DateTime.toShortFormat(): String {

    val dateTimeFormatter: DateTimeFormatter = DateTimeFormat.forPattern("dd MMMM yyyy")

    dateTimeFormatter.withZone(DateTimeZone.forID("Asia/Singapore"))

    return dateTimeFormatter.print(this)
}

fun DateTime.toLongFormat(): String {

    val dateTimeFormatter: DateTimeFormatter = DateTimeFormat.forPattern("EEEE, d MMMM yyyy 'at' h:mma")

    dateTimeFormatter.withZone(DateTimeZone.forID("Asia/Singapore"))

    return dateTimeFormatter.print(this)
}

fun DateTime.isToday(): Boolean {
    return LocalDate.now().compareTo(LocalDate(this)) == 0
}


fun DateTime.isYesterday(): Boolean {
    return LocalDate.now().minusDays(1).compareTo(LocalDate(this)) == 0
}

//public boolean isYesterday(DateTime time) {
//    return LocalDate.now().minusDays(1).compareTo(new LocalDate(time)) == 0;
//}

//public boolean isToday(DateTime time) {
//    return LocalDate.now().compareTo(new LocalDate(time)) == 0;
//}
//
//public boolean isTomorrow(DateTime time) {
//    return LocalDate.now().plusDays(1).compareTo(new LocalDate(time)) == 0;
//}
//
//public boolean isYesterday(DateTime time) {
//    return LocalDate.now().minusDays(1).compareTo(new LocalDate(time)) == 0;
//}