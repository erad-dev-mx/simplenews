package erad.simple.simplenews.data.remote.dto

import erad.simple.simplenews.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)