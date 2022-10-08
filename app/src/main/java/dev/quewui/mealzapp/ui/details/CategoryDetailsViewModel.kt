package dev.quewui.mealzapp.ui.details

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dev.quewui.mealzapp.model.CategoriesRepository
import dev.quewui.mealzapp.model.response.CategoryResponse

class CategoryDetailsViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val repository: CategoriesRepository = CategoriesRepository.getInstance()
    val categoryState = mutableStateOf<CategoryResponse?>(null)

    init {
        val categoryId = savedStateHandle.get<String>("category_id") ?: ""
        categoryState.value = repository.getCategory(categoryId)
    }
}