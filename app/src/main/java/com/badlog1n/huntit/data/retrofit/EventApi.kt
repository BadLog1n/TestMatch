package com.badlog1n.huntit.data.retrofit

import com.badlog1n.huntit.domain.models.MatchesResponse
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface EventApi {
    @GET("/v2.2/fixtures/?user=badlogin.super&token=f804688f7bd18a889aa095d0a603272b&t=schedule&d=2023-05-20")
    @Headers("Content-type: application/json")
    suspend fun getEventList(@Query("d") date: String): MatchesResponse
}