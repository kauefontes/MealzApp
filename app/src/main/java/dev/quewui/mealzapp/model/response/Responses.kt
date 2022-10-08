package dev.quewui.mealzapp.model.response

import com.google.gson.annotations.SerializedName

data class CategoriesResponse(val categories: List<CategoryResponse>)

data class CategoryResponse(
    @SerializedName("idCategory") val id: String,
    @SerializedName("strCategory") val name: String,
    @SerializedName("strCategoryThumb") val thumbnailUrl: String,
    @SerializedName("strCategoryDescription") val description: String
)