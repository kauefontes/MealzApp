package dev.quewui.mealzapp.ui.categories

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.quewui.mealzapp.model.CategoriesRepository
import dev.quewui.mealzapp.model.response.CategoryResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CategoriesViewModel(private val repository: CategoriesRepository = CategoriesRepository()) :
    ViewModel() {

    init {
        Log.d("TAG_COROUTINE", "we are about to launch a coroutine")
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("TAG_COROUTINE", "have launched the coroutine")
            val categories = getCategories()
            Log.d("TAG_COROUTINE", "we received the async data")
            categoriesState.value = categories
        }
        Log.d("TAG_COROUTINE", "other work")
    }

    val categoriesState: MutableState<List<CategoryResponse>> = mutableStateOf(emptyList())

    private suspend fun getCategories(): List<CategoryResponse> {
        return repository.getCategories().categories
    }
}