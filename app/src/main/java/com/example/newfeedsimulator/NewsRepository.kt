package com.example.newfeedsimulator

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NewsRepository {

    fun getNewsFlow(): Flow<News> = flow {
        var id = 1
        val categories = listOf("Hiburan", "Musik", "Kecantikan")

        while (true) {
            delay(2000)

            val news = News(
                id = id,
                title = "Berita ke-$id",
                category = categories.random(),
                content = "Ini isi berita ke-$id"
            )

            emit(news) // kirim berita
            id++
        }
    }
}