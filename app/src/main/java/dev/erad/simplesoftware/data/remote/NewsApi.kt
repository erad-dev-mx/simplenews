package dev.erad.simplesoftware.data.remote

import dev.erad.simplesoftware.data.remote.dto.NewsResponse
import dev.erad.simplesoftware.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}