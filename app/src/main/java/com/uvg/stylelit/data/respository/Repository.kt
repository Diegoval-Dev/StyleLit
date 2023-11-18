package com.uvg.stylelit.data.respository

import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.uvg.stylelit.data.networking.CategoriesResponse
import com.uvg.stylelit.data.networking.CategoryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext

class Repository {
    val db = Firebase.firestore
    val blusas = mutableListOf<DocumentReference>()

    suspend fun getCategories(type: String): CategoriesResponse {
        return withContext(Dispatchers.IO){
            val documents = db.collection(type)
                .get()
                .await().documents
            CategoriesResponse(
                documents.map {
                    CategoryResponse(
                        it.id,
                        it.getString("categoryName")?:""
                    )
                }
            )
        }
    }
    /*init {
        for (i in 1..5) {
            val blusaRef = db.collection("Woman")
                .document("Camisas")
                .collection("B. Larga")
                .document("blusa$i")
            blusas.add(blusaRef)
        }
    }*/

}