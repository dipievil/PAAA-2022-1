package br.pro.appcep.client

import br.pro.appcep.model.Endereco
import br.pro.appcep.service.CepService
import br.pro.appcep.util.APIUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CepClientApi (val cepService: CepService = APIUtils().cepService) {
    fun buscarEndereco (
        cep: String,
        onSuccess: (endereco: Endereco?) -> Unit,
        onFail: (erro: String?) -> Unit) {
        cepService.buscarEndereco(cep).enqueue(object : Callback<Endereco> {
            override fun onResponse(call: Call<Endereco>, response: Response<Endereco>) {
                if(response.isSuccessful)
                    onSuccess(response.body())
                else
                    onFail("Erro nao identificado!")
            }

            override fun onFailure(call: Call<Endereco>, t: Throwable) {
                onFail(t.message)
            }

        })
    }

}