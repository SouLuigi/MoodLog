package com.example.moodlog.datasource

import com.example.moodlog.model.MoodModel
import com.example.moodlog.view.MoodHistory
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DataSource {

    private val db = FirebaseFirestore.getInstance()
    private val _allMoods = MutableStateFlow<MutableList<MoodModel>>(mutableListOf())
    private val allMoods: StateFlow<MutableList<MoodModel>> = _allMoods


    fun saveMood(mood: String, description: String) {
        val moodData = hashMapOf(
            "mood" to mood,
            "description" to description
        )
        db.collection("moods").document().set(moodData).addOnSuccessListener {

        }.addOnFailureListener {
        }
    }

    fun getMoods(): Flow<MutableList<MoodModel>> {

        val listMood: MutableList<MoodModel> = mutableListOf()

        db.collection("moods").get().addOnCompleteListener { querySnapshot ->
            if (querySnapshot.isSuccessful) {

                for (document in querySnapshot.result) {
                    val moods = document.toObject(MoodModel::class.java)
                    listMood.add(moods)
                    _allMoods.value = listMood

//                    val mood = document.getString("mood")
//                    val description = document.getString("description")

                }

            }
        }
        return allMoods
    }
}