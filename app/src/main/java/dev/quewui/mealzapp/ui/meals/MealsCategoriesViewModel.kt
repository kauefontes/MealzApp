package dev.quewui.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import dev.quewui.mealzapp.model.MealsRepository
import dev.quewui.mealzapp.model.response.CategoryResponse

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {
        fun getMeals(): List<CategoryResponse> {
            return repository.getMeals().categories
        }
    }