package farkvar.com.utils.customscreen

import android.content.Context
import android.widget.Toast
import com.andexert.calendarlistview.library.DatePickerController
import com.andexert.calendarlistview.library.DayPickerView
import com.andexert.calendarlistview.library.SimpleMonthAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import farkvar.com.ui.bus.bushome.BusFragment

object CustomDate : DatePickerController {
    var context: Context? = null
    lateinit var listener: IDataSelectted
    lateinit var dialog: BottomSheetDialog
    fun customGetDate(
        context: Context,
        datePicker: DayPickerView,
        dialog: BottomSheetDialog,
        listener: IDataSelectted
    ) {
        this.context = context
        this.dialog=dialog
        datePicker.setController(this)
        this.listener = listener
    }

    override fun onDateRangeSelected(selectedDays: SimpleMonthAdapter.SelectedDays<SimpleMonthAdapter.CalendarDay>?) {

    }

    override fun onDayOfMonthSelected(year: Int, month: Int, day: Int) {
        var mMonth: String=(month+1).toString()
        var mDay: String=day.toString()
        if (month+1 < 10) {
            mMonth ="0"+mMonth
        }
        if (day < 10) {
            mDay ="0"+day.toString()
        }
        listener.selectedDate(year.toString()+"-"+mMonth+"-"+mDay)
        dialog.hide()

    }

    override fun getMaxYear(): Int {
        return 2020
    }


}

interface IDataSelectted {
    fun selectedDate(date: String)
}