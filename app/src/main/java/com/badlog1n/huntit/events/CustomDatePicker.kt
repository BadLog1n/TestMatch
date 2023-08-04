package com.badlog1n.huntit.events

import android.app.DatePickerDialog
import android.content.Context
import android.widget.DatePicker
import java.text.SimpleDateFormat
import java.util.*

class CustomDatePicker(private val context: Context, private val onDateSelected: (String) -> Unit) {

    private val dateFormat = "yyyy-MM-dd"
    private val calendar = Calendar.getInstance()

    fun showDatePicker() {
        val datePickerDialog = DatePickerDialog(
            context,
            dateSetListener,
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )

        // Set a date picker limit to only allow past dates
        datePickerDialog.datePicker.maxDate = System.currentTimeMillis() - 1000

        datePickerDialog.show()
    }

    private val dateSetListener = DatePickerDialog.OnDateSetListener { _: DatePicker, year: Int, month: Int, day: Int ->
        calendar.set(Calendar.YEAR, year)
        calendar.set(Calendar.MONTH, month)
        calendar.set(Calendar.DAY_OF_MONTH, day)

        val simpleDateFormat = SimpleDateFormat(dateFormat, Locale.US)
        val selectedDate = simpleDateFormat.format(calendar.time)
        onDateSelected.invoke(selectedDate)
    }
}
