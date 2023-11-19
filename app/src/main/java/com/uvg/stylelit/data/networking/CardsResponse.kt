package com.uvg.stylelit.data.networking

import com.google.gson.annotations.SerializedName

data class CardsResponse(val cards: List<Cards>)

data class Cards(
    @SerializedName("id") val id: String,
    @SerializedName("nombre") val name: String,
    @SerializedName("url") val urlImage: String
)