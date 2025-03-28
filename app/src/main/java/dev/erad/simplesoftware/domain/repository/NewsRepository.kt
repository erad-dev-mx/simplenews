package dev.erad.simplesoftware.domain.repository

import androidx.paging.PagingData
import dev.erad.simplesoftware.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {
    fun getNews(sources: List<String>): Flow<PagingData<Article>>
}