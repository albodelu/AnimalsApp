package com.alorma.animals.resources

import android.content.Context
import androidx.annotation.StringRes

class ResourceProvider(private val context: Context) {
    fun getString(@StringRes stringRes: Int, vararg args: Any): String =
        context.resources.getString(stringRes, *args)
}