package com.prilepskiy.myapplication.data.appservice

import android.content.Context
import android.content.SharedPreferences
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKeys


class PreferenceEncryptServiceImpl(private val context: Context): PreferenceEncryptService {

    private val masterKeyAlias = MasterKeys.getOrCreate(MasterKeys.AES256_GCM_SPEC)
    private val anySharedPrefs= EncryptedSharedPreferences.create(
        STORAGE_KEY,
        masterKeyAlias,
        context,
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    override fun getData()=anySharedPrefs.get(V_KEY,"")

    override fun setData(data: String) {
        anySharedPrefs.set(V_KEY,data)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = this.edit()
        operation(editor)
        editor.apply()
    }
    private operator fun SharedPreferences.set(key: String, value: Any?) {
        when (value) {
            is Int -> edit { it.putInt(key, value) }
            is Long -> edit { it.putLong(key, value) }
            is Float -> edit { it.putFloat(key, value) }
            is String -> edit { it.putString(key, value) }
            is Boolean -> edit { it.putBoolean(key, value) }
            else -> throw UnsupportedOperationException("Not implemented type")
        }
    }
    private inline operator fun <reified T : Any> SharedPreferences.get(
        key: String,
        defaultValue: T
    ): T {
        return when (T::class) {
            Int::class -> getInt(key, defaultValue as Int) as T
            Long::class -> getLong(key, defaultValue as Long) as T
            Float::class -> getFloat(key, defaultValue as Float) as T
            String::class -> getString(key, defaultValue as String) as T
            Boolean::class -> getBoolean(key, defaultValue as Boolean) as T
            else -> throw UnsupportedOperationException("Not implemented type")
        }
    }
    companion object{
        const val V_KEY="V_KEY"
        const val STORAGE_KEY="STORAGE_KEY"
    }

}