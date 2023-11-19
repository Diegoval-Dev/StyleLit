package com.uvg.stylelit.data.networking

import com.google.gson.annotations.SerializedName

data class ClothesResponse(val clothes: List<Clothes>)

data class Clothes(
    @SerializedName("id") val id: String,
    @SerializedName("brand") val brand: String,
    @SerializedName("colors") val colors: String,
    @SerializedName("name") val name: String,
    @SerializedName("price") val price: String,
    @SerializedName("sizes") val sizes: String,
    @SerializedName("imageURL") val imageUrl: String
)