package com.example.loginapirest.ui.config

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreManager(private val context: Context) {
    companion object {
        private val Context.dataStore: DataStore<Preferences> by preferencesDataStore("DATA_ITEM")
        val DATA_KEY = stringPreferencesKey("")
    }

    // to get the email
    val getValue: Flow<String?> = context.dataStore.data
        .map { preferences ->
            preferences[DATA_KEY] ?: ""
        }

    // to save the email
    suspend fun saveEmail(name: String) {
        context.dataStore.edit { preferences ->
            preferences[DATA_KEY] = name
        }
    }
}