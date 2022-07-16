package br.pro.appcep.model

data class Endereco(
    val cep: String,
    val logradouro: String,
    val localidade: String,
    val bairro: String,
    val complemento: String,
    val uf: String
)
