package br.pro.appcep.service

import br.pro.appcep.model.Endereco
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CepService {
    @GET("{cep}/json")
    fun buscarEndereco(@Path("cep") cep: String): Call<Endereco>
}