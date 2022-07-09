package br.pro.appcrudprodutosmem.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.pro.appcrudprodutosmem.R
import br.pro.appcrudprodutosmem.model.Produto

class ProdutoAdapter (private var listaProdutos: ArrayList<Produto>): RecyclerView.Adapter<ProdutoAdapter.ProdutoHolder> (){

    class ProdutoHolder(view: View): RecyclerView.ViewHolder(view) {
        var textoId: TextView = view.findViewById(R.id.textoId)
        var textoNome: TextView = view.findViewById(R.id.textoNome)
        var textoPreco: TextView = view.findViewById(R.id.textoPreco)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdutoHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_produto, parent, false)
        return ProdutoHolder(view)
    }

    override fun onBindViewHolder(holder: ProdutoHolder, position: Int) {
        holder.textoId.text = listaProdutos[position].id.toString()
        holder.textoNome.text = listaProdutos[position].nome
        holder.textoPreco.text = listaProdutos[position].preco.toString()

    }

    override fun getItemCount(): Int {
        return listaProdutos.size
    }
}