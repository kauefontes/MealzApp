package dev.quewui.mealzapp.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import dev.quewui.mealzapp.model.response.CategoryResponse
import kotlin.math.min

@Composable
fun CategoryDetails(category: CategoryResponse?) {
    val scrollState = rememberScrollState()
    val offset = min(1f, 1 - (scrollState.value / 1200f))
    val size by animateDpAsState(targetValue = max(100.dp, 200.dp * offset))
    Surface(color = MaterialTheme.colors.background) {
        Column {
            Surface(elevation = 4.dp) {
                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Card(
                        modifier = Modifier.padding(16.dp),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 4.dp,
                            color = Color.Blue
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
                                .size(size)
                        )

                    }
                    Text(
                        category?.name ?: "No name",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                Text("This is a text!", modifier = Modifier.padding(32.dp))
                Text("This is another text!", modifier = Modifier.padding(32.dp))
                Text("This is a text!", modifier = Modifier.padding(32.dp))
                Text("This is another text!", modifier = Modifier.padding(32.dp))
                Text("This is a text!", modifier = Modifier.padding(32.dp))
                Text("This is another text!", modifier = Modifier.padding(32.dp))
                Text("This is a text!", modifier = Modifier.padding(32.dp))
                Text("This is another text!", modifier = Modifier.padding(32.dp))
                Text("This is a text!", modifier = Modifier.padding(32.dp))
                Text("This is another text!", modifier = Modifier.padding(32.dp))
                Text("This is a text!", modifier = Modifier.padding(32.dp))
                Text("This is another text!", modifier = Modifier.padding(32.dp))
                Text("This is a text!", modifier = Modifier.padding(32.dp))
                Text("This is another text!", modifier = Modifier.padding(32.dp))
                Text("This is a text!", modifier = Modifier.padding(32.dp))
                Text("This is another text!", modifier = Modifier.padding(32.dp))
                Text("This is a text!", modifier = Modifier.padding(32.dp))
                Text("This is another text!", modifier = Modifier.padding(32.dp))
                Text("This is a text!", modifier = Modifier.padding(32.dp))
                Text("This is another text!", modifier = Modifier.padding(32.dp))
                Text("This is a text!", modifier = Modifier.padding(32.dp))
                Text("This is another text!", modifier = Modifier.padding(32.dp))
            }
        }
    }
}

@Preview
@Composable
fun CategoryCardPreview() {
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