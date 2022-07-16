package br.pro.appcep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import br.pro.appcep.client.CepClientApi

class MainActivity : AppCompatActivity() {
    val cepClientApi: CepClientApi by lazy {
        CepClientApi()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun consultarCep(view: View) {
        val cepEdit = findViewById<EditText>(R.id.editTextCep)
        val textCidade = findViewById<TextView>(R.id.textCidade)
        val cep = cepEdit.text.toString()

        cepClientApi.buscarEndereco(
            cep,
            onSuccess = { endereco ->
                textCidade.text = endereco?.localidade
            },
            onFail = { erro ->
                Toast.makeText(this, erro, Toast.LENGTH_SHORT).show()
            }
        )
    }
}