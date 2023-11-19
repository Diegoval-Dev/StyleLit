package com.uvg.stylelit.data.respository

import android.util.Log
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.uvg.stylelit.data.networking.Cards
import com.uvg.stylelit.data.networking.CardsResponse
import com.uvg.stylelit.data.networking.CategoriesResponse
import com.uvg.stylelit.data.networking.CategoryResponse
import com.uvg.stylelit.data.networking.Clothes
import com.uvg.stylelit.data.networking.ClothesResponse
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
                        it.getString("name")?:"",
                    )
                }
            )
        }
    }

    suspend fun getCards(type:String, category: String): CardsResponse{

        return withContext(Dispatchers.IO){
            val documents = db.collection("/$type/$category/$category")
                .get()
                .await().documents
            CardsResponse(
                documents.map{
                    Cards(
                        it.id,
                        it.getString("name")?:"",
                        it.getString("url")?:""
                    )
                }
            )
        }
    }


    suspend fun getClothes(type:String, category: String, cloth: String): ClothesResponse{
        return withContext(Dispatchers.IO){
            val documents = db.collection("/$type/$category/$category/$cloth/$cloth")
                .get()
                .await().documents
            ClothesResponse(
                documents.map {
                    Clothes(
                        it.id,
                        it.getString("brand")?:"",
                        it.getString("color")?:"",
                        it.getString("name")?:"",
                        it.getString("price")?:"",
                        it.getString("size")?:"",
                        it.getString("url")?:""
                    )
                }
            )
        }
    }


}