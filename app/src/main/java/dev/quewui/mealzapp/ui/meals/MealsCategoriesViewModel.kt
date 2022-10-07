package dev.quewui.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import dev.quewui.mealzapp.model.MealsRepository
import dev.quewui.mealzapp.model.response.MealsCategoriesResponse

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit) {
        return repository.getMeals { response ->
            successCallback(response)
        }
    }
}