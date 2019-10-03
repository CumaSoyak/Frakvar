package farkvar.com.utils.extensions

import android.os.Build
import android.text.Html
import android.text.Spanned
import android.widget.TextView
import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

fun String.toSpanned(): Spanned {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
        return Html.fromHtml(this, Html.FROM_HTML_MODE_LEGACY)
    } else {
        return Html.fromHtml(this)
    }
}

fun Double.formatMoney(): String {
    val symbols = DecimalFormatSymbols.getInstance(Locale("tr", "TR"))
    symbols.groupingSeparator = ','
    symbols.decimalSeparator = '.'
    val df = DecimalFormat("#.##", symbols)
    df.groupingSize = 3
    df.isGroupingUsed = true
    df.maximumFractionDigits = 2
    df.minimumFractionDigits = 2
    return df.format(this)
}

fun String.toDate(): String {
    var date = SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(this)
    return SimpleDateFormat("dd MMMM yyyy", Locale("tr", "TR")).format(date).toString()
}

fun String.toDateMonthDay(): String {
    var date = SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(this)
    return SimpleDateFormat("dd MMMM", Locale("tr", "TR")).format(date).toString()
}

fun String.toDateYear(): String {
    var date = SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(this)
    return SimpleDateFormat("yyyy", Locale("tr", "TR")).format(date).toString()
}

fun String.toHours(): String {
    var date = SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(this)
    return SimpleDateFormat("HH:mm", Locale("tr", "TR")).format(date).toString()
}

fun toDateFormat(text: String): String {
    var date: String = (text.substring(8, 10) + "/" + text.substring(5, 7) + "/" + text.substring(0, 4))
    return date
}

fun toDateMonthOfYear(text: String): String {
    val simpledateformat = SimpleDateFormat("MMMM")
    val date = Date(text.substring(0, 4).toInt(), text.substring(5, 7).toInt() - 1, text.substring(8, 10).toInt())
    val monthOfYear = simpledateformat.format(date)
    val day = text.substring(0, 4)
    return day + " " + monthOfYear
}

fun toDateMonthOfYearAndDay(text: String): ArrayList<String> {
    val dateList:ArrayList<String> =arrayListOf()
    val simpledateformat = SimpleDateFormat("MMMM")
    val date = Date(text.substring(0, 4).toInt(), text.substring(5, 7).toInt() - 1, text.substring(8, 10).toInt())
    val monthOfYear = simpledateformat.format(date)
    val day = text.substring(8, 10)

    val simpledateformatDay = SimpleDateFormat("EEEE")
    val dayString =
        Date(text.substring(0, 4).toInt(), text.substring(5, 7).toInt() - 1, text.substring(8, 10).toInt() - 1)
    val dayOfWeek = simpledateformatDay.format(dayString)
    //day + " " + monthOfYear + " " + dayOfWeek
    dateList.add(day)
    dateList.add(monthOfYear)
    dateList.add(dayOfWeek)
    return dateList
}


