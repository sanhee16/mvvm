package com.sandy.memo.viewmodel

import android.appwidget.AppWidgetManager
import android.content.ComponentName
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sandy.memo.R
import com.sandy.memo.common.Event
import com.sandy.memo.widget.WidgetProvider
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

open class BaseViewModel : ViewModel() {
    private val _viewEvent = MutableLiveData<Event<Any>>()
    val viewEvent: LiveData<Event<Any>> get() = _viewEvent

    companion object {
        const val SHOW_MEMO_LIST = "SHOW_MEMO_LIST"
        const val MAKE_NEW_MEMO = "MAKE_NEW_MEMO"
        const val SHOW_PROGRESS_BAR = "SHOW_PROGRESS_BAR"
        const val HIDE_PROGRESS_BAR = "HIDE_PROGRESS_BAR"
        const val SHOW_DIALOG = "SHOW_DIALOG"
        const val MEMO_SAVE_EVENT = "MEMO_SAVE_EVENT"
        const val SET_PASSWORD = "SET_PASSWORD"
        const val CHECK_PASSWORD = "CHECK_PASSWORD"
        const val ALERT_WRONG_PASSWORD = "ALERT_WRONG_PASSWORD"
        const val RIGHT_PASSWORD = "RIGHT_PASSWORD"
        const val SETTING = "SETTING"
    }

    fun viewEvent(content: Any) {
        _viewEvent.postValue(Event(content))
    }

    fun getCurrentTime(): String =
        LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))

    fun showProgressBar() = viewEvent(SHOW_PROGRESS_BAR)

    fun hideProgressBar() = viewEvent(HIDE_PROGRESS_BAR)
}