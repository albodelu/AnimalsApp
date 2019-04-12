package com.alorma.animals.navigation.commands

import android.net.Uri
import com.alorma.animals.navigation.Command
import com.alorma.animals.navigation.DEFAULT_SCHEMA

val dashboardCommand: () -> Command = {
    val uri = Uri.Builder()
        .scheme(DEFAULT_SCHEMA)
        .authority("dashboard")
        .build()

    Command(uri)
}