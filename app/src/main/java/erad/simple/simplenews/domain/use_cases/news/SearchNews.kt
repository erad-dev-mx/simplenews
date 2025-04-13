package erad.simple.simplenews.domain.use_cases.news

import androidx.paging.PagingData
import erad.simple.simplenews.domain.model.Article
import erad.simple.simplenews.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(searchQuery = searchQuery, sources = sources)
    }
}