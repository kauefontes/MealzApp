package dev.quewui.mealzapp.model

import dev.quewui.mealzapp.model.api.CategoriesWebService
import dev.quewui.mealzapp.model.response.CategoriesResponse
import dev.quewui.mealzapp.model.response.CategoryResponse

class CategoriesRepository(private val webService: CategoriesWebService = CategoriesWebService()) {
    private var cachedCategories = listOf<CategoryResponse>()
    suspend fun getCategories(): CategoriesResponse {
        val response = webService.getCategories()
        cachedCategories = response.categories
        return webService.getCategories()
    }

    fun getCategory(categoryId: String): CategoryResponse? {
        return cachedCategories.firstOrNull() {
            it.id == categoryId
        }
    }

    companion object {
        @Volatile
        private var instance: CategoriesRepository? = null
        fun getInstance() = instance ?: synchronized(this) {
            instance ?: CategoriesRepository().also { instance = it }
        }
    }
}