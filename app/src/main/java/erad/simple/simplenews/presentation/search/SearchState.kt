package erad.simple.simplenews.presentation.search

import androidx.paging.PagingData
import erad.simple.simplenews.domain.model.Article
import kotlinx.coroutines.flow.Flow


data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
) {
}