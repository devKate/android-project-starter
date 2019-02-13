package com.katien.project.sharedprefs

import android.app.Application
import android.content.Context


class SharedPrefs constructor(context: Application) {
    private val PREF_KEY_UNIT_ID = "unitId"
    private val sharedPrefs = context.getSharedPreferences("com.katien.project.sharedprefs.PREFERENCE_FILE_KEY", Context.MODE_PRIVATE)
    private val editor = sharedPrefs.edit()


    var unitId: String
        get() = sharedPrefs.getString(PREF_KEY_UNIT_ID, "")
        set(value) = saveString(PREF_KEY_UNIT_ID, value)


    private fun saveString(key: String, value: String?) {
        value?.let {
            editor.putString(key, value)
            editor.commit()
        } ?: editor.remove(key)
    }
}