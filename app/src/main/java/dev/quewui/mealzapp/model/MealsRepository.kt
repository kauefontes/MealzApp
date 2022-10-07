package dev.quewui.mealzapp.model

import dev.quewui.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository {
    fun getMeals(): MealsCategoriesResponse = MealsCategoriesResponse(arrayListOf())
}