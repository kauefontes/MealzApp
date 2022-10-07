package dev.quewui.mealzapp.ui.categories

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
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
    var isExpanded by remember { mutableStateOf(false) }
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentHeight(align = Alignment.Top),
        elevation = 8.dp
    ) {
        Row(
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .padding(4.dp)
                .animateContentSize()
        ) {
            CategoryPicture(category.thumbnailUrl, 88.dp)
            Column(
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
                    .fillMaxWidth(0.8f)
            ) {
                CategoryTitle(category.name)
                CategorySumary(category.description, isExpanded)
            }
            Icon(
                if (isExpanded)
                    Icons.Filled.KeyboardArrowUp
                else
                    Icons.Filled.KeyboardArrowDown,
                "",
                modifier = Modifier
                    .padding(16.dp)
                    .align(
                        if (isExpanded)
                            Alignment.Bottom
                        else
                            Alignment.CenterVertically
                    )
                    .clickable { isExpanded = !isExpanded }
            )
        }
    }
}

@Composable
fun CategoryPicture(pictureUrl: String, pictureSize: Dp) {
    AsyncImage(
        model = (pictureUrl),
        contentDescription = "",
        modifier = Modifier
            .size(pictureSize),
        alignment = Alignment.Center
    )
}

@Composable
fun CategorySumary(description: String, isExpanded: Boolean) {
    CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {

    }
    Text(
        text = description,
        style = MaterialTheme.typography.subtitle2,
        overflow = TextOverflow.Ellipsis,
        textAlign = TextAlign.Start,
        maxLines = if (isExpanded) 10 else 4

    )
}

@Composable
fun CategoryTitle(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.h5
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        CategoriesList()
    }
}