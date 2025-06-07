package com.example.moodlog.datasource

import com.google.firebase.firestore.FirebaseFirestore

class DataSource {

    private val db = FirebaseFirestore.getInstance()

    fun saveMood(mood: String, description: String) {
        val moodData = hashMapOf(
            "mood" to mood,
            "description" to description
        )
        db.collection("moods").document().set(moodData).addOnSuccessListener {

        }.addOnFailureListener {
        }
    }
}