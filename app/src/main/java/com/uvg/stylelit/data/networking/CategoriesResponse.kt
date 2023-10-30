package com.uvg.stylelit.data.networking
import com.google.gson.annotations.SerializedName
data class CategoriesResponse(val categories: List<String>)
//CategoryResponse
data class CategoryResponse(
    @SerializedName("id") val id: String,
    @SerializedName("categoryName") val name: String
)