package com.example.flashcardapp

import kotlinx.coroutines.flow.Flow
interface ProfileRepository {
    suspend fun saveProfile(profileData : ProfileData)
    fun getProfile() : Flow<ProfileData>
    suspend fun clear()

}