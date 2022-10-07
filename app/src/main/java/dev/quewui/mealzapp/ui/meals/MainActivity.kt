package dev.quewui.mealzapp.ui.meals

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
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
    val categories = viewModel.getMeals()
    Row {
        if (categories != null) {
            for (category in categories) {
                Text(text = category.name)
            }
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