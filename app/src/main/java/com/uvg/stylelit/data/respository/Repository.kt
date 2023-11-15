package com.uvg.stylelit.data.respository

import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class Repository {
    val db = Firebase.firestore
    val blusas = mutableListOf<DocumentReference>()

    init {
        for (i in 1..5) {
            val blusaRef = db.collection("Woman")
                .document("Camisas")
                .collection("B. Larga")
                .document("blusa$i")
            blusas.add(blusaRef)
        }
    }

}