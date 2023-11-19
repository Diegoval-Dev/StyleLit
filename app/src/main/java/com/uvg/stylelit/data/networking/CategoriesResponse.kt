package com.uvg.stylelit.data.networking
import com.google.gson.annotations.SerializedName
data class CategoriesResponse(val categories: List<CategoryResponse>)
//CategoryResponse
data class CategoryResponse(
    @SerializedName("id") val id: String,
    @SerializedName("nombre") val name: String
)