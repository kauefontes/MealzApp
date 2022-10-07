package dev.quewui.mealzapp.model

import dev.quewui.mealzapp.model.api.MealsWebService
import dev.quewui.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    suspend fun getCategories(): MealsCategoriesResponse {
        return webService.getCategories()
    }
}