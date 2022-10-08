package dev.quewui.mealzapp.ui.categories

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import dev.quewui.mealzapp.ui.details.CategoryDetails
import dev.quewui.mealzapp.ui.details.CategoryDetailsViewModel
import dev.quewui.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                Food4FunApp()
            }
        }
    }
}

@Composable
fun Food4FunApp() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "categories_list") {
        composable(route = "categories_list") {
            CategoriesList { navigationCategoryId ->
                navController.navigate("category_details/$navigationCategoryId")

            }
        }
        composable(
            route = "category_details/{category_id}",
            arguments = listOf(navArgument("category_id") {
                type = NavType.StringType
            })
        ) {
            val viewModel: CategoryDetailsViewModel = viewModel()
            CategoryDetails(viewModel.categoryState.value)
        }
    }
}