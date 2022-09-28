package com.brendarojas.criptomonedaswizeline.config

import com.brendarojas.criptomonedaswizeline.utils.Constants.URL_BASE
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {
    fun getConfigRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}