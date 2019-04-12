package com.alorma.animals.widget

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.inputmethod.InputMethodManager
import com.alorma.animals.R
import com.google.android.material.textfield.TextInputEditText

class ReadOnlyEditText @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = R.attr.editTextStyle
) : TextInputEditText(context, attrs, defStyleAttr) {

    var onActionListener: (() -> Unit)? = null
    private var isTouchFocus = false

    init {
        setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down, 0)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        if (event.action == MotionEvent.ACTION_UP) {
            callActionListener()
            isTouchFocus = true
        }
        return super.onTouchEvent(event)
    }

    override fun onFocusChanged(focused: Boolean, direction: Int, previouslyFocusedRect: Rect?) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect)
        if (focused && !isTouchFocus) {
            callActionListener()
        }
        isTouchFocus = false
    }

    private fun callActionListener() {
        val imm = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(this.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        if (onActionListener != null) {
            onActionListener?.invoke()
        }
    }

    override fun getDefaultEditable(): Boolean {
        return false
    }
}