package com.example.moodlog.datasource

import android.util.Log
import com.example.moodlog.model.MoodModel
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.util.UUID

class DataSource {

    private val db = FirebaseFirestore.getInstance()
    private val _allMoods = MutableStateFlow<MutableList<MoodModel>>(mutableListOf())
    private val allMoods: StateFlow<MutableList<MoodModel>> = _allMoods


    fun saveMood(mood: String, description: String) {

        val moodData = hashMapOf(
            "mood" to mood,
            "description" to description
        )

        db.collection("moods")
            .document(mood)
            .set(moodData)
            .addOnSuccessListener {

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
                }
            }
        }
        return allMoods
    }
    fun deleteMood(mood: String) {
        db.collection("moods").document(mood).delete()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.d("DELETE_MOOD", "Mood deletado com sucesso: $mood")
                } else {
                    Log.d("DELETE_MOOD", "Erro ao deletar: ${task.exception}")
                }
            }
            .addOnFailureListener { e ->
                Log.e("DELETE_MOOD", "Falha ao deletar o documento: ${e.message}", e)
            }
    }
}