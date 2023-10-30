package com.uvg.stylelit.data.networking

import com.google.gson.annotations.SerializedName

data class ClothesResponse(val clothes: List<Clothes>)

data class Clothes(
    @SerializedName("id") val id: String,
    @SerializedName("cloth") val cloth: String,
    @SerializedName("imageURL") val imageUrl: String
)