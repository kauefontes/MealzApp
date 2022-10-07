package dev.quewui.mealzapp.ui.categories

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import dev.quewui.mealzapp.model.response.CategoryResponse
import dev.quewui.mealzapp.ui.theme.MealzAppTheme


@Composable
fun CategoriesList() {
    val viewModel: CategoriesViewModel = viewModel()
    val categories = viewModel.categoriesState.value
    LazyColumn {
        items(categories) { category ->
            CategoryCard(category = category)
        }
    }
}

@Composable
fun CategoryCard(category: CategoryResponse) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        elevation = 8.dp
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CategoryTitle(category.name)
            CategoryPicture(category.thumbnailUrl, 200.dp)
            CategorySumary(category.description)
        }
    }
}

@Composable
fun CategoryPicture(pictureUrl: String, pictureSize: Dp) {
    AsyncImage(
        model = (pictureUrl),
        contentDescription = "",
        modifier = Modifier
            .fillMaxWidth()
            .height(pictureSize)
            .padding(16.dp)
    )
}

@Composable
fun CategorySumary(description: String) {
    Text(
        text = description,
        style = MaterialTheme.typography.body2,
        modifier = Modifier.padding(20.dp, 0.dp, 20.dp, 20.dp),
        textAlign = TextAlign.Center

    )
}

@Composable
fun CategoryTitle(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(5.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        CategoriesList()
    }
}