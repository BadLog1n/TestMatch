package com.badlog1n.huntit.data.retrofit

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitImpl {

    private fun getService(): EventApi {
        return createRetrofit(BaseInterceptor.interceptor).create(EventApi::class.java)
    }

    private fun createRetrofit(interceptor: Interceptor): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_LOCATIONS)
            .addConverterFactory(GsonConverterFactory.create())
            .client(createOkHttpClient(interceptor))
            .build()
    }

    private fun createOkHttpClient(interceptor: Interceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return httpClient.build()
    }

    companion object {
        private const val BASE_URL_LOCATIONS = "https://api.soccersapi.com"
        fun getService() = RetrofitImpl().getService()
    }
}


/*
class RetrofitImpl {
    object MatchApiClient {
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.soccersapi.com/v2.2/fixtures")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService: EventApi = retrofit.create(EventApi::class.java)
    }
}*/
