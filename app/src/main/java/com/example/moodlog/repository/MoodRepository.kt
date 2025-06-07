package com.example.moodlog.repository

import com.example.moodlog.datasource.DataSource

class MoodRepository() {
    private val dataSource = DataSource()
    fun saveMood(mood: String, description: String) {
        dataSource.saveMood(mood, description)
    }


}