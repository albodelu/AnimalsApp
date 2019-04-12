package com.alorma.animals.navigation;

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.afollestad.materialdialogs.MaterialDialog

const val DEFAULT_SCHEMA = "alorma"

sealed class Navigator {
    abstract fun navigate(command: Command, navigationOptions: NavigationOptions = NavigationOptions.Normal)

    class ActivityNavigator(private val activity: Activity?) : Navigator() {
        override fun navigate(command: Command, navigationOptions: NavigationOptions) {
            activity?.let {
                val intent = command.toIntent(it)
                it.doNavigate(intent, navigationOptions)
            }
        }
    }

    class FragmentNavigator(private val fragment: Fragment?) : Navigator() {
        override fun navigate(command: Command, navigationOptions: NavigationOptions) {
            fragment?.requireActivity()?.let { activity ->
                val intent = command.toIntent(activity)
                activity.doNavigate(intent, navigationOptions)
            }
        }
    }
}

sealed class NavigationOptions {
    object WithFinish : NavigationOptions()
    object WithClearTaskFlag : NavigationOptions()
    data class WithResult(val result: Int) : NavigationOptions()
    object Normal : NavigationOptions()
}

fun Activity.doNavigate(intent: Intent, navigationOptions: NavigationOptions = NavigationOptions.Normal) {
    whenSupportIntent(this, intent) {
        when (navigationOptions) {
            NavigationOptions.WithFinish -> startActivity(intent).also { finish() }
            is NavigationOptions.WithResult -> startActivityForResult(intent, navigationOptions.result)
            NavigationOptions.Normal -> startActivity(intent)
            NavigationOptions.WithClearTaskFlag -> {
                intent.flags += Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent).also { finish() }
            }
        }
    }
}

private fun whenSupportIntent(context: Context, intent: Intent, block: () -> Unit) {
    if (intent.resolveActivity(context.packageManager) != null) {
        block()
    } else {
        showNavigationNotFoundDialog(context)
    }
}

private fun showNavigationNotFoundDialog(context: Context)
        : Dialog = MaterialDialog(context).show {
    title(text = "Not found")
    message(text = "This feature is not available yet")
    positiveButton(text = "Shame") {
        (context as? Activity)?.let {
            Toast.makeText(context, "Shame!\nShame!\nShame!", Toast.LENGTH_SHORT).show()
        }
    }
}
