package dev.quewui.mealzapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import dev.quewui.mealzapp.model.response.CategoryResponse
import dev.quewui.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                CategoriesScreen()
            }
        }
    }
}

@Composable
fun CategoriesScreen() {
    val viewModel: MealsCategoriesViewModel = viewModel()
    val categoriesResponse: MutableState<List<CategoryResponse>> = remember {
        mutableStateOf(emptyList())
    }
    viewModel.getMeals { response ->
        categoriesResponse.value = response?.categories.orEmpty()
    }
    LazyColumn {
        items(categoriesResponse.value) { category ->
            Text(text = category.name, style = MaterialTheme.typography.h2)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        CategoriesScreen()
    }
}