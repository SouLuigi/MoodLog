package com.example.moodlog.repository

import com.example.moodlog.datasource.DataSource
import com.example.moodlog.model.MoodModel
import kotlinx.coroutines.flow.Flow

class MoodRepository() {
    private val dataSource = DataSource()
    fun saveMood(mood: String, description: String) {
        dataSource.saveMood(mood, description)
    }
    fun getMoods(): Flow<MutableList<MoodModel>> {
        return dataSource.getMoods()

    }
    fun deleteMood(mood: String){
        dataSource.deleteMood(mood)
    }
}