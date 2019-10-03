package farkvar.com.utils.extensions

import android.content.Context
import android.os.Build
import android.os.SystemClock
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.annotation.RequiresApi
import androidx.core.view.ViewCompat

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}

fun View.clickWithDebounce(debounceTime: Long = 600L, action: () -> Unit) {
    this.setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0

        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return
            else action()

            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}

fun View.showKeyboard(show: Boolean) {
    val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    if (show) {
        if (requestFocus()) imm.showSoftInput(this, 0)
    } else {
        imm.hideSoftInputFromWindow(windowToken, 0)
    }
}

// Adds window insets to the view while entire activity is fullscreen.
fun View.applyWindowInsets(applyTopInset: Boolean = true, applyOtherInsets: Boolean = true): Unit {
    if (applyTopInset || applyOtherInsets) {
        ViewCompat.setOnApplyWindowInsetsListener(
            this
        ) { view, insets ->
            // Set padding for needed insets
            view.setPadding(
                if (applyOtherInsets) insets.systemWindowInsetLeft else view.paddingLeft,
                if (applyTopInset) insets.systemWindowInsetTop else view.paddingTop,
                if (applyOtherInsets) insets.systemWindowInsetRight else view.paddingRight,
                if (applyOtherInsets) insets.systemWindowInsetBottom else view.paddingBottom
            )

            // Return without consumed insets
            insets.replaceSystemWindowInsets(
                if (applyOtherInsets) 0 else insets.systemWindowInsetLeft,
                if (applyTopInset) 0 else insets.systemWindowInsetTop,
                if (applyOtherInsets) 0 else insets.systemWindowInsetRight,
                if (applyOtherInsets) 0 else insets.systemWindowInsetBottom
            )
        }
    } else {
        // Listener is not needed
        ViewCompat.setOnApplyWindowInsetsListener(this, null)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    fun View.cancelTransition() {
        transitionName = null
    }

    fun View.isVisible() = this.visibility == View.VISIBLE

    fun View.gone() {
        this.visibility = View.VISIBLE
    }

}

fun View.gone() {
    this.visibility = View.VISIBLE
}