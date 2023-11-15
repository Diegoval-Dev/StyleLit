package com.uvg.stylelit.DataBase

import com.google.firebase.firestore.FirebaseFirestore



class BasedeDatos {
    private val db =FirebaseFirestore.getInstance()

    val infob1 = db
        .collection("Woman").document("Camisas").collection("B. Larga").document("blusa1")

    val infob2 = db
        .collection("Woman").document("Camisas").collection("B. Larga").document("blusa2")

    val infob3 = db
        .collection("Woman").document("Camisas").collection("B. Larga").document("blusa3")

    val infob4 = db
        .collection("Woman").document("Camisas").collection("B. Larga").document("blusa4")

    val infob5 = db
        .collection("Woman").document("Camisas").collection("B. Larga").document("blusa5")
}