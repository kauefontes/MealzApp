package dev.quewui.mealzapp.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import dev.quewui.mealzapp.model.response.CategoryResponse

@Composable
fun CategoryDetails(category: CategoryResponse?) {
    var categoryPictureState by remember {
        mutableStateOf(CategoryPictureState.Normal)
    }
    val transition = updateTransition(categoryPictureState, label = "")
    val pictureSizeDp: Dp by transition.animateDp(targetValueByState = { it.size }, label = "")
    val color by transition.animateColor(targetValueByState = { it.color }, label = "")
    val borderWidth by transition.animateDp(targetValueByState = { it.borderWidth }, label = "")
    Card {
        Column {
            Row {
                Card(
                    modifier = Modifier.padding(16.dp),
                    shape = CircleShape,
                    border = BorderStroke(
                        width = borderWidth,
                        color = color
                    )
                ) {
                    Image(
                        rememberAsyncImagePainter(
                            ImageRequest.Builder(LocalContext.current)
                                .data(data = category?.thumbnailUrl)
                                .apply(block = fun ImageRequest.Builder.() {
                                    transformations(CircleCropTransformation())
                                }).build()
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .size(pictureSizeDp)
                            .padding(8.dp)
                    )

                }
                Text(
                    category?.name ?: "No name",
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterVertically)
                )
            }
            Button(onClick = {
                categoryPictureState =
                    if (categoryPictureState == CategoryPictureState.Normal)
                        CategoryPictureState.Expanded
                    else
                        CategoryPictureState.Normal
            }) {
                Text("Change state of the current category picture")
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    CategoryDetails(
        CategoryResponse(
            "4",
            "Lamb",
            "https://www.themealdb.com/images/category/lamb.png",
            "Lamb, hogget, and mutton are the meat of domestic sheep (species Ovis aries) at different ages.\\r\\n\\r\\nA sheep in its first year is called a lamb, and its meat is also called lamb. The meat of a juvenile sheep older than one year is hogget; outside the USA this is also a term for the living animal. The meat of an adult sheep is mutton, a term only used for the meat, not the living animals. The term mutton is almost always used to refer to goat meat in the Indian subcontinent.\\r\\n\\r\\n"
        )
    )
}

enum class CategoryPictureState(val color: Color, val size: Dp, val borderWidth: Dp) {
    Normal(Color.Cyan, 120.dp, 4.dp),
    Expanded(Color.Blue, 200.dp, 12.dp)
}