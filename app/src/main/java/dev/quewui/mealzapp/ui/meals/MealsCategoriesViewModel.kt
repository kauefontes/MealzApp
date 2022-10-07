package dev.quewui.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import dev.quewui.mealzapp.model.MealsRepository
import dev.quewui.mealzapp.model.response.CategoryResponse

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {
    suspend fun getCategories(): List<CategoryResponse> {
        return repository.getCategories().categories
    }
}