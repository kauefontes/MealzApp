package dev.quewui.mealzapp.model

import dev.quewui.mealzapp.model.api.MealsWebService
import dev.quewui.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMeals(): MealsCategoriesResponse? {
        return webService.getMeals().execute().body()
    }
}