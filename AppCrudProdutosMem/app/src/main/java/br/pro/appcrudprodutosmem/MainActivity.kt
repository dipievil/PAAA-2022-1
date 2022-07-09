package br.pro.appcrudprodutosmem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.pro.appcrudprodutosmem.adapter.ProdutoAdapter
import br.pro.appcrudprodutosmem.model.Produto

private var listaProdutos: ArrayList<Produto> = ArrayList()
private lateinit var recyclerView: RecyclerView
private lateinit var viewManager: RecyclerView.LayoutManager
private lateinit var viewAdapter: ProdutoAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaProdutos.add(Produto(1, "Produto 1",30.0))
        listaProdutos.add(Produto(2, "Produto 2",50.0))
        listaProdutos.add(Produto(3, "Produto 3",70.0))
        listaProdutos.add(Produto(4, "Produto 4",80.0))

        viewManager = LinearLayoutManager(this)
        viewAdapter = ProdutoAdapter(listaProdutos)

        recyclerView = findViewById<RecyclerView>(R.id.recyclerView).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

    }
}