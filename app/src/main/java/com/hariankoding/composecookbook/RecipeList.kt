package com.hariankoding.composecookbook

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun RecipeList(viewModel: RecipeListViewModel) {
    val recipeListState = viewModel.recipeListFlow.collectAsStateWithLifecycle()
    LazyColumn {
        items(recipeListState.value) {
            RecipeCard(
                recipe = it,
                Modifier.padding(16.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun RecipeListPreview() {
    val viewModel = RecipeListViewModel()
    RecipeList(viewModel = viewModel)
}