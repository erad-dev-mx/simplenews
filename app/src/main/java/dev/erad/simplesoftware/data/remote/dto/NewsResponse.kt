package dev.erad.simplesoftware.data.remote.dto

import dev.erad.simplesoftware.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)