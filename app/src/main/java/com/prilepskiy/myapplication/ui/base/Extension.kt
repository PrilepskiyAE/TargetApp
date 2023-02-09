package com.prilepskiy.myapplication.ui.base
import android.content.Context
import android.content.res.Resources
import android.util.Log
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.NavHostFragment
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.runBlocking
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.concurrent.TimeUnit

inline fun <reified T> Flow<T>.observeInLifecycle(
    lifecycleOwner: LifecycleOwner
) = FlowObserver(lifecycleOwner, this)

inline fun <reified F> getCurrentFragment(navHostFragment: NavHostFragment): F? {
    return if (navHostFragment.isAdded && navHostFragment.childFragmentManager.fragments.size > 0) {
        if (navHostFragment.childFragmentManager.fragments[0] is F) {
            navHostFragment.childFragmentManager.fragments[0] as F
        } else {
            null
        }
    } else null
}
fun View.setMargins(
    leftMarginDp: Int,
    topMarginDp: Int,
    rightMarginDp: Int,
    bottomMarginDp: Int,
    withDp: Boolean = false
) {
    if (layoutParams is ViewGroup.MarginLayoutParams) {
        (layoutParams as ViewGroup.MarginLayoutParams).apply {
            topMargin = if (withDp) pxToDp(topMarginDp) else dpToPx(topMarginDp)
            rightMargin = if (withDp) pxToDp(rightMarginDp) else dpToPx(rightMarginDp)
            leftMargin = if (withDp) pxToDp(leftMarginDp) else dpToPx(leftMarginDp)
            bottomMargin = if (withDp) pxToDp(bottomMarginDp) else dpToPx(bottomMarginDp)
        }

        requestLayout()
    }
}

fun Context.pxToDp(px: Int): Int = (px / Resources.getSystem().displayMetrics.density).toInt()

fun getData():String
{
    val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
    val date: LocalDate = LocalDate.now()

    val date2: LocalDate = LocalDate.now()

    return date.format(formatter)
}

fun getLastDay(lday: Int):Long{
    val current = LocalDateTime.now()
    Log.d("TAG55", "onView:${current} ")
    val day = TimeUnit.MILLISECONDS.toDays(lday-current.second.toLong())
    Log.d("TAG55", "onView:${day} ")
    return day
}

fun View.pxToDp(px: Int): Int = context.pxToDp(px)

fun View.dpToPx(dp: Int): Int = context.dpToPx(dp)

fun Context.dpToPx(dp: Int): Int = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), resources.displayMetrics).toInt()

fun getUniqueId(): Long {
    runBlocking {
        delay(1L)
    }
    return System.currentTimeMillis()
}