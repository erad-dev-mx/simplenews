package dev.erad.simplesoftware.domain.use_cases.news

import androidx.paging.PagingData
import dev.erad.simplesoftware.domain.model.Article
import dev.erad.simplesoftware.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}