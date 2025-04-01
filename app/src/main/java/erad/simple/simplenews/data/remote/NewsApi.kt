package erad.simple.simplenews.data.remote

import erad.simple.simplenews.data.remote.dto.NewsResponse
import erad.simple.simplenews.util.Constants.API_KEY
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