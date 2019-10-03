package farkvar.com.utils

import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.*

object DateUtils {
    fun getCurrentDateTime(): String {
        val calendar = Calendar.getInstance()
        var mDate = calendar.time
        val sdf = SimpleDateFormat("yyyy-MM-dd hh:mm:ss")
        return sdf.format(mDate)
    }

    fun getCurrentDate(): String {
        val calendar = Calendar.getInstance()
        var mDate = calendar.time
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        return sdf.format(mDate)
    }

    fun getCurrentDateInReverseForm(): String {
        val calendar = Calendar.getInstance()
        var mDate = calendar.time
        val sdf = SimpleDateFormat("dd.MM.yyyy")
        return sdf.format(mDate)
    }

    fun getCurrentHourSecond(): String {
        val calendar = Calendar.getInstance()
        var mDate = calendar.time
        val sdf = SimpleDateFormat("HH:mm")
        return sdf.format(mDate)
    }

    fun getTomorrowDate(daysLater:Int): String
    {
        val calendar = Calendar.getInstance()
        val format = SimpleDateFormat("yyyy-MM-dd")
        calendar.time = Date()
        calendar.add(Calendar.DATE,daysLater)
        val date = format.format((calendar.time))
        return date
    }

    fun getTomorrowDateInReverseForm(daysLater:Int): String
    {
        val calendar = Calendar.getInstance()
        val format = SimpleDateFormat("dd.MM.yyyy")
        calendar.time = Date()
        calendar.add(Calendar.DATE,daysLater)
        val date = format.format((calendar.time))
        return date
    }

    fun isCurrentTimeBetweenTwoTime(startTime:String?,endTime:String?): Boolean
    {
        val time = getCurrentHourSecond()
        if (time <= endTime!! && time >= startTime!!)
            return true
        return false
    }

    fun checkHours(time: String, endTime: String): Boolean {
        val pattern = "HH:mm"
        val sdf = SimpleDateFormat(pattern)

        try {
            val date1 = sdf.parse(time)
            val date2 = sdf.parse(endTime)
            return date1.before(date2)
        } catch (e: ParseException) {
            e.printStackTrace()
        }

        return false
    }
}