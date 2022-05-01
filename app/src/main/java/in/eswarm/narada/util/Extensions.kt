package `in`.eswarm.narada.util

import `in`.eswarm.narada.AppComponent
import `in`.eswarm.narada.NaradaApplication
import android.content.Context

fun Context.getAppComponent(): AppComponent {
    val application = applicationContext as NaradaApplication
    return application.appComponent
}