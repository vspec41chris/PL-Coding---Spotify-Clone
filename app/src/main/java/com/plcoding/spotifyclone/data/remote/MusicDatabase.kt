package com.plcoding.spotifyclone.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.plcoding.spotifyclone.data.entities.Song
import com.plcoding.spotifyclone.utils.Constant.SONG_COLLECTION
import kotlinx.coroutines.tasks.await


class MusicDatabase {

    private val fireStore = FirebaseFirestore.getInstance()
    private val songCollection = fireStore.collection(SONG_COLLECTION)


    suspend fun getAllSongs(): List<Song>{
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }
}