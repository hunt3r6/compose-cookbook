package com.hariankoding.composecookbook

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun RecipeCard(recipe: Recipe, modifier: Modifier) {
    Surface(
        modifier = modifier,
        color = MaterialTheme.colorScheme.surface,
        border = BorderStroke(0.dp, MaterialTheme.colorScheme.secondary),
        shape = RoundedCornerShape(8.dp),
        tonalElevation = 2.dp,
        shadowElevation = 10.dp
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = recipe.imageResource),
                contentDescription = recipe.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(144.dp)
            )
            Text(
                modifier = Modifier.padding(
                    top = 16.dp,
                    start = 16.dp
                ),
                text = recipe.title,
                style = MaterialTheme.typography.headlineLarge,
                fontWeight = FontWeight(700)
            )
            Row {
                Column(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        bottom = 16.dp,
                        end = 16.dp
                    )
                ) {

                    for (ingredient in recipe.ingredients) {
                        Text(
                            text = ". $ingredient",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
                Column(
                    modifier = Modifier.padding(
                        start = 4.dp,
                        end = 16.dp,
                        bottom = 16.dp
                    )
                ) {
                    Text(
                        text = recipe.description,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }

    }

}

@Preview(showBackground = true)
@Composable
fun RecipeCardPreview() {
    val viewModel = RecipeListViewModel()
    val previewRecipe = Recipe(
        imageResource = R.drawable.noodles,
        title = "Ramen",
        ingredients = listOf("Noodles", "Eggs", "Mushrooms", "Carrots", "Soy sauce"),
        description = "Japan’s famous noodles-and-broth dish. It’s meant to be slurped LOUDLY."
    )
    RecipeCard(previewRecipe, Modifier.padding(16.dp))
}