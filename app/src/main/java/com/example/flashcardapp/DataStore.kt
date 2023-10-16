package com.example.flashcardapp

import android.content.Context
import androidx.datastore.core.DataStore
import kotlinx.coroutines.flow.Flow
import java.util.prefs.Preferences

const val PROFILE_DATASTORE = "profile_datastore"
private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = PROFILE_DATASTORE)
class ProfileRepositoryDataStore(private val context: Context) : ProfileRepository
{
    companion object {
        val NAME = stringPreferencesKey("NAME")
        val COUNTER = intPreferencesKey("COUNTER")
    }

        override suspend fun saveProfile(profileData : ProfileData){
            context.dataStore.edit {
                it[NAME] = profileData.name
                it[COUNTER] = profileData.counter
            }
        }

    override fun getProfile(): Flow<ProfileData> = context.dataStore.data.map {
        ProfileData(
            name = it[NAME] ?: "",
            counter = it[COUNTER] ?: 0
        )
    }

    override suspend fun clear() {
        context.dataStore.edit {
            it.clear()
        }
    }
}