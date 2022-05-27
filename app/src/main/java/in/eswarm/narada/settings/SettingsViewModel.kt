package `in`.eswarm.narada.settings

import `in`.eswarm.narada.preferences.AppPreferences
import `in`.eswarm.narada.util.preferences
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SettingsViewModel(val appPreferences: AppPreferences) : ViewModel()

class SettingsViewModelFactory(private val context: Context) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SettingsViewModel(context.preferences) as T
    }
}
