package br.pro.appcep.util

import br.pro.appcep.service.CepService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://viacep.com.br/ws/";

class APIUtils {

    val retrofit by lazy {
        Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    }

    val cepService by lazy {
        retrofit.create(CepService::class.java)
    }
}