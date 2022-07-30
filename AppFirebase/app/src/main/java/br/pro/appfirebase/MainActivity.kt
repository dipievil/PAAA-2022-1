package br.pro.appfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = Firebase.firestore

        val produto = hashMapOf (
            "nome" to "Produto 2",
            "preco" to 40.0
        )

        db.collection("produtos")
            .add(produto)
            .addOnSuccessListener { documentReference ->
                Log.d("FIREBASE", "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w("FIREBASE", "Error adding document", e)
            }

        db.collection("produtos")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    val nome = document.data.get("nome")
                    Log.d("FIREBASE", "${document.id} => ${nome}")
                }
            }
            .addOnFailureListener { e ->
                Log.w("FIREBASE", "Error adding document", e)
            }
    }
}