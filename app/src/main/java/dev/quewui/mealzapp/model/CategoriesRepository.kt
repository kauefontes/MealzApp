package dev.quewui.mealzapp.model

import dev.quewui.mealzapp.model.api.CategoriesWebService
import dev.quewui.mealzapp.model.response.CategoriesCategoriesResponse

class CategoriesRepository(private val webService: CategoriesWebService = CategoriesWebService()) {
    suspend fun getCategories(): CategoriesCategoriesResponse {
        return webService.getCategories()
    }
}