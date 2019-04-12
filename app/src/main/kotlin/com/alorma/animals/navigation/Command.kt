package com.alorma.animals.navigation

import android.content.Context
import android.content.Intent
import android.net.Uri

data class Command(val uri: Uri)

fun Command.toIntent(context: Context)
        : Intent = Intent(Intent.ACTION_VIEW, this.uri).apply {
    `package` = context.applicationContext?.packageName
}