package com.example.newfeedsimulator
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    private val repository = NewsRepository()

    // Menyimpan daftar berita
    private val _newsList = MutableStateFlow<List<News>>(emptyList())
    val newsList: StateFlow<List<News>> = _newsList

    // Menghitung jumlah berita yang dibaca
    private val _readCount = MutableStateFlow(0)
    val readCount: StateFlow<Int> = _readCount

    init {
        viewModelScope.launch {
            repository.getNewsFlow().collect { news ->
                _newsList.value = _newsList.value + news
            }
        }
    }

    fun markAsRead() {
        _readCount.value++
    }
    fun filterByCategory(category: String): Flow<List<News>> {
        return newsList.map { list ->
            list.filter { it.category == category }
        }
    }
    suspend fun getNewsDetail(news: News): String {
        kotlinx.coroutines.delay(1000)
        return "Detail lengkap: ${news.content}"
    }
}